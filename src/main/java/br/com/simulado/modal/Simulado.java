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
@Table(name="simulado")
public class Simulado{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String nome;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "simulado")
	private List<Prova> provas;
	
	public Simulado(long id,String nome, List<Prova> provas) {
		this.id = id;
		this.nome = nome;
		this.provas = provas;
	}
	public Simulado() {
	}

	public String getNome() {
		return nome;
	}

	public List<Prova> getProvas() {
		return provas;
	}

	public Prova retornaProvaPorNome(String nome) throws NotFoundException {
		Prova prova = new Prova();
		prova =  this.provas
				.stream()
				.filter(p -> p.getNome().equalsIgnoreCase(nome))
				.findAny()
				.orElseThrow(() -> new NotFoundException("Prova ["+nome+"] do Simulado ["+this.nome+"] não foi encontrado"));
		return prova;
	}
	
}
