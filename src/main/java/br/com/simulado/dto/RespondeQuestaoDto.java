package br.com.simulado.dto;

public class RespondeQuestaoDto {
	private String resposta;

	public RespondeQuestaoDto() {
	}

	public RespondeQuestaoDto(String resposta) {
		this.resposta = resposta;
	}

	public String getResposta() {
		return resposta;
	}

	public void setResposta(String resposta) {
		this.resposta = resposta;
	}
}
