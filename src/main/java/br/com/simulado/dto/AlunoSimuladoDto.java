package br.com.simulado.dto;

public class AlunoSimuladoDto {
	private String nome;
	private String cpf;

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public AlunoSimuladoDto(String nome, String cpf) {
		this.nome = nome;
		this.cpf = cpf;
	}

}
