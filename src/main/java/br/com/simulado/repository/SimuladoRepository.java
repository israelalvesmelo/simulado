package br.com.simulado.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.simulado.modal.Simulado;

@Repository
public interface SimuladoRepository extends CrudRepository<Simulado, Long>{
	Simulado findByNome(String nome);
}
