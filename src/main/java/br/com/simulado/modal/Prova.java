package br.com.simulado.modal;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import javassist.NotFoundException;

@Entity
@Table(name = "prova")
public class Prova {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String nome;

	@OneToOne
	@JoinColumn(name = "provaGabaritoId")
	private Gabarito gabarito;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "prova")
	private List<Questao> questoes;

	@ManyToOne
	private Simulado simulado;

	public Prova(long id, String nome, Gabarito gabarito, List<Questao> questoes, Simulado simulado) {
		this.id = id;
		this.nome = nome;
		this.gabarito = gabarito;
		this.questoes = questoes;
		this.simulado = simulado;
	}

	public Prova() {
	}

	public String getNome() {
		return nome;
	}

	public Gabarito getGabarito() {
		return gabarito;
	}

	public Questao retornaQuestaoPorNumero(int numero) throws NotFoundException {
		Questao questao = new Questao();
		questao = this.questoes.stream().filter(q -> q.getNumero() == numero).findAny()
				.orElseThrow(() -> new NotFoundException(
						"Questão [" + numero + "] da Prova [" + this.nome + "] não foi encontrado"));
		return questao;
	}
}
