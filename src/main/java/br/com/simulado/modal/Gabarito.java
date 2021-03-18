package br.com.simulado.modal;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import javassist.NotFoundException;

@Entity
@Table(name="gabarito")
public class Gabarito {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "gabarito")
	private List<Resposta> respostas;

	public Gabarito() {}

	public List<Resposta> getRespostas() {
		return respostas;
	}
	
	public Resposta retornaRespostaPeloNumeroQuestao(int numero) throws NotFoundException {
		Resposta resposta = new Resposta();
		resposta =  this.respostas
				.stream()
				.filter(r -> r.getQuestao().getNumero() == numero)
				.findAny()
				.orElseThrow(() -> new NotFoundException("Resposta para a questão ["+numero+"] não foi encontrada"));
		return resposta;
	}
}
