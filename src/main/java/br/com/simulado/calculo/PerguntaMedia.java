package br.com.simulado.calculo;

import java.util.List;

import br.com.simulado.modal.Nivel;
import br.com.simulado.modal.RespostaAluno;

public class PerguntaMedia implements CalculaNota {

	@Override
	public int calcularNota(List<RespostaAluno> respostasAluno) {
		int soma = this.getPontuacao(respostasAluno, Nivel.MEDIA.getNome());
		int qtd = this.getQuantidadeDePereguntasCertas(respostasAluno, Nivel.MEDIA.getNome());

		return qtd * soma;
	}

}
