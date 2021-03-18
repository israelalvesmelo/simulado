package br.com.simulado.calculo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.aspectj.lang.annotation.Before;
import org.assertj.core.api.Assert;
import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.event.annotation.BeforeTestClass;

import br.com.simulado.modal.Aluno;
import br.com.simulado.modal.LetraResposta;
import br.com.simulado.modal.Nivel;
import br.com.simulado.modal.Prova;
import br.com.simulado.modal.Questao;
import br.com.simulado.modal.RespostaAluno;

public class PerguntaFacilTest {
	private CalculaNota calculaNota;

	@Test
	public void dado3respostasDoAlunoQuandoCalcularNovaRetornarTotalDeNotasDePerguntasFaceis() {
		Questao questao1 = mock(Questao.class);
		Questao questao2 = mock(Questao.class);

		when(questao1.getNivel()).thenReturn(Nivel.FACIL);
		when(questao2.getNivel()).thenReturn(Nivel.MEDIA);
		
		calculaNota = new PerguntaFacil();

		RespostaAluno respostaAluno = new RespostaAluno();
		respostaAluno.setAluno(new Aluno());
		respostaAluno.setPontuacao(Nivel.FACIL.getPontuacao());
		respostaAluno.setProva(new Prova());
		respostaAluno.setResposta(LetraResposta.A);
		respostaAluno.setQuestao(questao1);
		
		RespostaAluno respostaAluno2 = new RespostaAluno();
		respostaAluno2.setAluno(new Aluno());
		respostaAluno2.setPontuacao(0);
		respostaAluno2.setProva(new Prova());
		respostaAluno2.setResposta(LetraResposta.C);
		respostaAluno2.setQuestao(questao1);

		RespostaAluno respostaAluno3 = new RespostaAluno();
		respostaAluno3.setAluno(new Aluno());
		respostaAluno3.setPontuacao(Nivel.MEDIA.getPontuacao());
		respostaAluno3.setProva(new Prova());
		respostaAluno3.setResposta(LetraResposta.D);
		respostaAluno3.setQuestao(questao2);

		
		List<RespostaAluno> respostasAlunos = java.util.Arrays.asList(respostaAluno,respostaAluno2, respostaAluno3);
		
		int pontuacao =  calculaNota.getPontuacao(respostasAlunos, Nivel.FACIL.getNome());
		assertEquals(15, pontuacao);
	}
}
