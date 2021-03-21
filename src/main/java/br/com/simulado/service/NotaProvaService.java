package br.com.simulado.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.simulado.calculo.PerguntaDificil;
import br.com.simulado.calculo.PerguntaFacil;
import br.com.simulado.calculo.PerguntaMedia;
import br.com.simulado.modal.Aluno;
import br.com.simulado.modal.NotaProva;
import br.com.simulado.modal.Prova;
import br.com.simulado.modal.RespostaAluno;
import br.com.simulado.repository.NotaProvaRepository;
import javassist.NotFoundException;

@Service
public class NotaProvaService {

	@Autowired
	private NotaProvaRepository notaProvaRepository;

	@Autowired
	private RespostaAlunoService respostaAlunoService;

	public Optional<NotaProva> calculaNotaProva(Aluno aluno, Prova prova) throws NotFoundException {
		Optional<List<RespostaAluno>> respostasAluno = respostaAlunoService.buscaRespostaAlunoPeloAlunoProva(aluno,
				prova);
		Optional<NotaProva> notaProva = this.buscaNotaProvaPeloAlunoProva(aluno, prova);

		if (notaProva.isEmpty()) {
			notaProva = Optional.of(new NotaProva());
		}

		if (respostasAluno.isPresent()) {
			int valorNotaPerguntaFacil = new PerguntaFacil().calcularNota(respostasAluno.get());
			int valorNotaPerguntaMedia = new PerguntaMedia().calcularNota(respostasAluno.get());
			int valorNotaPerguntaDificil = new PerguntaDificil().calcularNota(respostasAluno.get());

			notaProva.get().setNota(valorNotaPerguntaFacil + valorNotaPerguntaMedia + valorNotaPerguntaDificil + 600);
		} else {
			notaProva.get().setNota(600);
		}

		notaProva.get().setProva(prova);
		notaProva.get().setAluno(aluno);
		notaProvaRepository.save(notaProva.get());
		return notaProva;
	}

	private Optional<NotaProva> buscaNotaProvaPeloAlunoProva(Aluno aluno, Prova prova) throws NotFoundException {
		return notaProvaRepository.findByAlunoAndProva(aluno, prova);
	}

}
