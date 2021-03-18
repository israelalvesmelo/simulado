package br.com.simulado.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.simulado.modal.Aluno;
import br.com.simulado.modal.Simulado;
import br.com.simulado.repository.AlunoRepository;
import javassist.NotFoundException;

@Service
public class AlunoService {
	@Autowired
	private AlunoRepository alunoRepository;
	
	public Aluno buscaAlunoPorCpfESimulado(String cpf, Simulado simulado) throws NotFoundException {
		Aluno aluno = alunoRepository.findByCpfAndSimulados(cpf, simulado)
		.orElseThrow(() -> new NotFoundException("Aluno não foi encontrado no simulado"));
		
		return aluno;
	}
	
	public List<Aluno> buscaAlunoPorSimulado(Simulado simulado) throws NotFoundException {
		List<Aluno> aluno = alunoRepository.findBySimulados(simulado)
				.orElseThrow(() -> new NotFoundException("Aluno não foi encontrado no simulado"));
				
				return aluno;
	}
}
