package br.com.simulado.modal;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "resposta")
public class Resposta {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@OneToOne
	private Questao questao;
	@Enumerated(EnumType.STRING)
	private LetraResposta resposta;
	@ManyToOne
	private Gabarito gabarito;

	public Resposta() {
	}

	public Resposta(Questao questao, LetraResposta resposta, Gabarito gabarito) {
		this.questao = questao;
		this.resposta = resposta;
		this.gabarito = gabarito;
	}

	public Questao getQuestao() {
		return questao;
	}

	public LetraResposta getResposta() {
		return resposta;
	}

}
