package br.com.simulado.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class AlunoDto {

	private String nome;
	@JsonIgnore
	private String cpf;

	private int nota;
	private int ranking;
	
	public AlunoDto(String cpf, String nome, int nota, int ranking) {
		this.cpf = cpf;
		this.nome = nome;
		this.nota = nota;
		this.ranking = ranking;
	}
	
	public AlunoDto(String cpf, String nome, int nota) {
		this(cpf, nome, nota, 0);
	}

	public AlunoDto() {
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Integer getNota() {
		return nota;
	}
	public void setNota(int nota) {
		this.nota += nota;
	}
	public int getRanking() {
		return ranking;
	}
	public void setRanking(int ranking) {
		this.ranking = ranking;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	
}
