package br.com.simulado.dto;

import br.com.simulado.modal.Questao;

public class QuestaoDto {
	private int numero;
	private String descricao;
	private String nivel;

	public QuestaoDto() {
	}

	public QuestaoDto(Questao questao) {
		this(questao.getDescricao(), questao.getNumero(), questao.getNivel().getNome());
	}

	public QuestaoDto(String descricao, int numero, String nivel) {
		this.descricao = descricao;
		this.numero = numero;
		this.nivel = nivel;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getNivel() {
		return nivel;
	}

	public void setNivel(String nivel) {
		this.nivel = nivel;
	}

}
