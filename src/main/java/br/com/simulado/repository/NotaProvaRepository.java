package br.com.simulado.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.simulado.modal.Aluno;
import br.com.simulado.modal.NotaProva;
import br.com.simulado.modal.Prova;

@Repository
public interface NotaProvaRepository extends CrudRepository<NotaProva, Long> {

	Optional<NotaProva> findByAlunoAndProva(Aluno aluno, Prova prova);
}
