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
	private static final String ALUNO_NAO_ENCONTRADO = "Aluno não foi encontrado no simulado";
	@Autowired
	private AlunoRepository alunoRepository;

	public Aluno buscaAlunoPorCpfESimulado(String cpf, Simulado simulado) throws NotFoundException {
		if ((cpf == null || cpf.isEmpty()) || simulado == null) {
			throw new IllegalArgumentException("CPF e simulado do aluno deve ser informado");
		}
		Aluno aluno = alunoRepository.findByCpfAndSimulados(cpf, simulado)
				.orElseThrow(() -> new NotFoundException(ALUNO_NAO_ENCONTRADO));

		return aluno;
	}

	public List<Aluno> buscaAlunoPorSimulado(Simulado simulado) throws NotFoundException {
		if (simulado == null) {
			throw new IllegalArgumentException("Simulado do aluno deve ser informado");
		}
		List<Aluno> aluno = alunoRepository.findBySimulados(simulado)
				.orElseThrow(() -> new NotFoundException(ALUNO_NAO_ENCONTRADO));

		return aluno;
	}
}
