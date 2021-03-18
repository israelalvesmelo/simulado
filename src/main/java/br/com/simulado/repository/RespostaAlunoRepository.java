package br.com.simulado.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import br.com.simulado.modal.Aluno;
import br.com.simulado.modal.Prova;
import br.com.simulado.modal.Questao;
import br.com.simulado.modal.RespostaAluno;

@Repository
public interface RespostaAlunoRepository extends CrudRepository<RespostaAluno, Long>{
	Optional<RespostaAluno> findByAlunoAndQuestao(Aluno aluno, Questao questao);
	Optional<List<RespostaAluno>> findByAlunoAndProva(Aluno aluno,Prova prova);
}
