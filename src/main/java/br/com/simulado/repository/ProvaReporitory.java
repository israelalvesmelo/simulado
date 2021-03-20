package br.com.simulado.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.simulado.modal.Prova;

@Repository
public interface ProvaReporitory extends CrudRepository<Prova, Long> {
	Prova findBySimuladoAndNome(String simaulado, String nome);

}
