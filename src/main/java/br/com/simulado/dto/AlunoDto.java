package br.com.simulado.dto;

public class AlunoDto {

	private String nome;

	private int nota;
	private int ranking;
	private String cpf;

	public AlunoDto(String nome, String cpf, int nota, int ranking) {
		this.nome = nome;
		this.cpf = cpf;
		this.nota = nota;
		this.ranking = ranking;
	}

	public AlunoDto(String nome, int nota) {
		this(nome,"", nota, 0);
	}

	public AlunoDto() {
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getNota() {
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
