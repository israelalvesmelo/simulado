package br.com.simulado.modal;

public enum Nivel {
	FACIL("Fácil", 15), 
	MEDIA("Média", 12), 
	DIFICIL("Difícil", 8);

	private String nome;
	private int pontuacao;

	Nivel(String nome, int pontuacao) {
		this.nome = nome;
		this.pontuacao = pontuacao;
	}

	public String getNome() {
		return nome;
	}

	public int getPontuacao() {
		return pontuacao;
	}

	public boolean temValor(String nome) {
		return this.nome.equalsIgnoreCase(nome);
	}
}
