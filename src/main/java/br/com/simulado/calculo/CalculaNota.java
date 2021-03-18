package br.com.simulado.calculo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import br.com.simulado.modal.RespostaAluno;

public interface CalculaNota {

	default int getPontuacao(List<RespostaAluno> respostasAluno, String nivel) {
		List<Integer> pontuacao = new ArrayList<>();
		pontuacao = respostasAluno.stream().filter(r -> r.getQuestao().getNivel().temValor(nivel))
				.map(RespostaAluno::getPontuacao).collect(Collectors.toList());

		int soma = 0;

		for (Integer valor : pontuacao) {
			soma = soma + valor;
		}

		return soma;
	}

	default int getQuantidadeDePereguntasCertas(List<RespostaAluno> respostasAluno, String nivel) {
		int qtd = (int) respostasAluno.stream()
				.filter(r -> r.getPontuacao() != 0)
				.filter(r -> r.getQuestao().getNivel().temValor(nivel))
				.count();
//TODO: VALIDAR SE O CALCULO DA NOTA ESTA OK
		return qtd;
	}

	int calcularNota(List<RespostaAluno> respostasAluno);

}
