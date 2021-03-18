package br.com.simulado.modal;

import java.security.InvalidAlgorithmParameterException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum Nivel {
	FACIL("Fácil", 15), 
	MEDIA("Média", 12),
	DIFICIL("Difícil", 8);

	private String nome;
	private int pontuacao;
	private static List<Nivel> niveis;

	static {
		niveis = new ArrayList<>();
		niveis.addAll(Arrays.asList(FACIL, MEDIA, DIFICIL));
	}
	
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

//	static Nivel retornaNivelPeloNome(String nome) {
//		return niveis.stream()
//				.filter(nivel -> nivel.getNome().equals(nome))
//				.findAny()
//				.orElseThrow(() -> new IllegalArgumentException("Nível ["+nome+"] não encontrado"));
//	}
	
	public boolean temValor(String nome) {
		return this.nome.equalsIgnoreCase(nome);
	}
}
