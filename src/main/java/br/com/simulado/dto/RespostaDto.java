package br.com.simulado.dto;

import br.com.simulado.modal.LetraResposta;
import br.com.simulado.modal.Resposta;

public class RespostaDto {
	private QuestaoDto questao;
	private LetraResposta resposta;

	public RespostaDto() {
	}

	public RespostaDto(Resposta resposta) {
		this(new QuestaoDto(resposta.getQuestao()), resposta.getResposta());
	}

	public RespostaDto(QuestaoDto questao, LetraResposta resposta) {
		this.questao = questao;
		this.resposta = resposta;
	}

	public QuestaoDto getQuestao() {
		return questao;
	}

	public void setQuestao(QuestaoDto questao) {
		this.questao = questao;
	}

	public LetraResposta getResposta() {
		return resposta;
	}

	public void setResposta(LetraResposta resposta) {
		this.resposta = resposta;
	}
}
