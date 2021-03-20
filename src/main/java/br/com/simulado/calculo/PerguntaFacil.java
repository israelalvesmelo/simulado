package br.com.simulado.calculo;

import java.util.List;

import br.com.simulado.modal.Nivel;
import br.com.simulado.modal.RespostaAluno;

public class PerguntaFacil implements CalculaNota {

	@Override
	public int calcularNota(List<RespostaAluno> respostasAluno) {
		if (respostasAluno == null || respostasAluno.isEmpty()) {
			return 0;
		}

		int soma = this.getPontuacao(respostasAluno, Nivel.FACIL.getNome());
		int qtd = this.getQuantidadeDePereguntasCertas(respostasAluno, Nivel.FACIL.getNome());

		return qtd * soma;
	}

}
