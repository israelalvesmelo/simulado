package br.com.simulado.modal;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "resposta_aluno")
public class RespostaAluno {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Enumerated(EnumType.STRING)
	private LetraResposta resposta;
	@OneToOne
	private Questao questao;
	@OneToOne
	private Prova prova;
	@OneToOne
	private Aluno aluno;
	private int pontuacao;

	public RespostaAluno() {
	}

	public RespostaAluno(LetraResposta resposta, Questao questao, Prova prova, Aluno aluno, int pontuacao) {
		this.resposta = resposta;
		this.questao = questao;
		this.prova = prova;
		this.aluno = aluno;
		this.pontuacao = pontuacao;
	}

	public LetraResposta getResposta() {
		return resposta;
	}

	public void setResposta(LetraResposta resposta) {
		this.resposta = resposta;
	}

	public Questao getQuestao() {
		return questao;
	}

	public void setQuestao(Questao questao) {
		this.questao = questao;
	}

	public Prova getProva() {
		return prova;
	}

	public void setProva(Prova prova) {
		this.prova = prova;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public int getPontuacao() {
		return pontuacao;
	}

	public void setPontuacao(int pontuacao) {
		this.pontuacao = pontuacao;
	}

}
