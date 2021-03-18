package br.com.simulado.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.simulado.modal.Aluno;
import br.com.simulado.modal.Simulado;

@Repository
public interface AlunoRepository extends CrudRepository<Aluno, Long>{
	Optional<Aluno> findByCpfAndSimulados(String cpf, Simulado simulado);

	Optional<List<Aluno>> findBySimulados(Simulado simulado);
}
