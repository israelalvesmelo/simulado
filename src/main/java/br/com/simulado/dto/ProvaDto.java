package br.com.simulado.dto;

import br.com.simulado.modal.Prova;

public class ProvaDto {
	private String nome;

	public ProvaDto() {
	}

	public ProvaDto(Prova prova) {
		this(prova.getNome());
	}

	public ProvaDto(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
