package br.com.simulado.modal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum LetraResposta {
	A("A"), 
	B("B"), 
	C("C"), 
	D("D");

	private String nome;
	private static List<LetraResposta> letras;

	static {
		letras = new ArrayList<>();
		letras.addAll(Arrays.asList(A, B, C, D));
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	LetraResposta(String nome) {
		this.nome = nome;
	}

	public static LetraResposta retornaLetraRespostaPeloNome(String nome) {
		return letras.stream().filter(l -> l.getNome().equalsIgnoreCase(nome)).findAny()
				.orElseThrow(() -> new IllegalArgumentException("Resposta [" + nome + "] não encontrada"));
	}
}
