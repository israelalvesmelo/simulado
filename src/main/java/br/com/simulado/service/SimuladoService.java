package br.com.simulado.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.simulado.dto.AlunoDto;
import br.com.simulado.dto.AlunoSimuladoDto;
import br.com.simulado.dto.RankingDto;
import br.com.simulado.dto.SimuladoDto;
import br.com.simulado.modal.Aluno;
import br.com.simulado.modal.NotaProva;
import br.com.simulado.modal.Prova;
import br.com.simulado.modal.Simulado;
import br.com.simulado.repository.SimuladoRepository;
import javassist.NotFoundException;

@Service
public class SimuladoService {

	@Autowired
	private SimuladoRepository simuladoRepository;

	@Autowired
	private AlunoService alunoService;

	@Autowired
	private NotaProvaService notaProvaService;

	public List<SimuladoDto> buscaSimulados() {
		List<Simulado> simulados = (List<Simulado>) this.simuladoRepository.findAll();
		List<SimuladoDto> simuladosDto = new ArrayList<>();
		simulados.stream().forEach(s -> simuladosDto.add(new SimuladoDto().criarSimuladoDtoPorSimulado(s)));

		return simuladosDto;
	}

	public Simulado buscaSimuladoPeloNome(String nomeSimulado) throws NotFoundException {
		Simulado simulado = this.simuladoRepository.findByNome(nomeSimulado);
		if (simulado == null) {
			throw new NotFoundException("Simulado [" + nomeSimulado + "] não foi encontrado");
		}
		return simulado;
	}

	public RankingDto calculaRanking(String nomeSimulado) throws NotFoundException {
		Simulado simulado = this.buscaSimuladoPeloNome(nomeSimulado);
		List<Aluno> alunos = this.alunoService.buscaAlunoPorSimulado(simulado);
		List<Prova> provas = simulado.getProvas();
		RankingDto ranking = new RankingDto();

		for (Aluno aluno : alunos) {
			AlunoDto alunoDto = new AlunoDto();
			alunoDto.setNome(aluno.getNome());
			alunoDto.setCpf(aluno.getCpf());
			for (Prova prova : provas) {
				Optional<NotaProva> notaProva = this.notaProvaService.calculaNotaProva(aluno, prova);

				alunoDto.setNota(notaProva.get().getNota());
			}
			ranking.addAlunoDto(alunoDto);
		}

		return ranking;
	}
	
	public List<AlunoSimuladoDto> buscaTodosOsAlunosPorSimulado(String nomeSimulado) throws NotFoundException{
		List<AlunoSimuladoDto> alunosSimuladoDto = new ArrayList<>();
		Simulado simulado = this.buscaSimuladoPeloNome(nomeSimulado);
		List<Aluno> alunos = this.alunoService.buscaAlunoPorSimulado(simulado);
		
		for (Aluno aluno : alunos) {
			alunosSimuladoDto.add(new AlunoSimuladoDto(aluno.getNome(), aluno.getCpf()));
		}
		
		return alunosSimuladoDto;
	}

}
