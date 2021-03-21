package br.com.simulado.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.simulado.dto.RespondeQuestaoDto;
import br.com.simulado.dto.ResultadoQuestaoDto;
import br.com.simulado.modal.Aluno;
import br.com.simulado.modal.Gabarito;
import br.com.simulado.modal.LetraResposta;
import br.com.simulado.modal.Prova;
import br.com.simulado.modal.Questao;
import br.com.simulado.modal.RespostaAluno;
import br.com.simulado.modal.Simulado;
import br.com.simulado.repository.RespostaAlunoRepository;
import javassist.NotFoundException;

@Service
public class RespostaAlunoService {
	@Autowired
	private SimuladoService simuladoService;

	@Autowired
	private RespostaAlunoRepository respostaAlunoRepository;

	@Autowired
	private AlunoService alunoService;

	public ResultadoQuestaoDto salvaRespostaAluno(String nomeSimulado, String nomeProva, int numeroQuestao, String cpf,
			RespondeQuestaoDto respostaDto) throws NotFoundException {

		if(respostaDto.getResposta() == null) {
			throw new IllegalArgumentException("Resposta deve ser informada");
		}
		
		Simulado simulado = this.simuladoService.buscaSimuladoPeloNome(nomeSimulado);
		Aluno aluno = alunoService.buscaAlunoPorCpfESimulado(cpf, simulado);
		Prova prova = simulado.retornaProvaPorNome(nomeProva);
		Questao questao = prova.retornaQuestaoPorNumero(numeroQuestao);

		RespostaAluno respostaAluno = respostaAlunoRepository.findByAlunoAndQuestao(aluno, questao)
				.orElse(new RespostaAluno());
		respostaAluno.setAluno(aluno);
		respostaAluno.setProva(prova);
		respostaAluno.setQuestao(questao);
		LetraResposta letraResposta = LetraResposta.retornaLetraRespostaPeloNome(respostaDto.getResposta());
		respostaAluno.setResposta(letraResposta);

		ResultadoQuestaoDto resultadoQuestaoDto = new ResultadoQuestaoDto();
		resultadoQuestaoDto.setResposta(letraResposta.getNome());

		if (this.acertouResposta(letraResposta, questao, prova.getGabarito())) {
			respostaAluno.setPontuacao(questao.getNivel().getPontuacao());
			resultadoQuestaoDto.setStatus("Resposta correta");
		} else {
			respostaAluno.setPontuacao(0);
			resultadoQuestaoDto.setStatus("Resposta incorreta");
		}

		respostaAlunoRepository.save(respostaAluno);
		return resultadoQuestaoDto;
	}

	private boolean acertouResposta(LetraResposta resposta, Questao questao, Gabarito gabarito)
			throws NotFoundException {
		LetraResposta valorRespostaGabarito = gabarito.retornaRespostaPeloNumeroQuestao(questao.getNumero())
				.getResposta();
		return valorRespostaGabarito.getNome().equals(resposta.getNome()) ? true : false;
	}

	public Optional<List<RespostaAluno>> buscaRespostaAlunoPeloAlunoProva(Aluno aluno, Prova prova) {
		return respostaAlunoRepository.findByAlunoAndProva(aluno, prova);
	}
}
