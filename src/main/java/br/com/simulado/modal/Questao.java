package br.com.simulado.modal;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="questao")
public class Questao {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private int numero;
	private String descricao;
	@Enumerated(EnumType.STRING)
	private Nivel nivel;
	@ManyToOne
	private Prova prova;
	
	
	
	public Questao() {}

	public Questao(long id, String descricao, int numero, Nivel nivel) {
		this.id = id;
		this.descricao = descricao;
		this.numero = numero;
		this.nivel = nivel;
	}

	public int getNumero() {
		return numero;
	}

	public String getDescricao() {
		return descricao;
	}

	public Nivel getNivel() {
		return nivel;
	}

}
