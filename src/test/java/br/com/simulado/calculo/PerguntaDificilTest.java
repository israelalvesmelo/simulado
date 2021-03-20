package br.com.simulado.calculo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;

import br.com.simulado.modal.Aluno;
import br.com.simulado.modal.LetraResposta;
import br.com.simulado.modal.Nivel;
import br.com.simulado.modal.Prova;
import br.com.simulado.modal.Questao;
import br.com.simulado.modal.RespostaAluno;

public class PerguntaDificilTest {
	private CalculaNota calculaNota = new PerguntaDificil();

	@Test
	public void dadoRespostasDoAlunoComNiveisDiferentes_QuandoCalcularNova_RetornarTotalDeNotasDePerguntasFaceis() {
		Questao questao1 = mock(Questao.class);
		Questao questao2 = mock(Questao.class);

		when(questao1.getNivel()).thenReturn(Nivel.FACIL);
		when(questao2.getNivel()).thenReturn(Nivel.DIFICIL);

		RespostaAluno respostaAluno1 = mock(RespostaAluno.class);
		when(respostaAluno1.getAluno()).thenReturn(new Aluno());
		when(respostaAluno1.getProva()).thenReturn(new Prova());
		when(respostaAluno1.getResposta()).thenReturn(LetraResposta.A);
		when(respostaAluno1.getPontuacao()).thenReturn(Nivel.FACIL.getPontuacao());
		when(respostaAluno1.getQuestao()).thenReturn(questao1);

		RespostaAluno respostaAluno2 = mock(RespostaAluno.class);
		when(respostaAluno2.getAluno()).thenReturn(new Aluno());
		when(respostaAluno2.getProva()).thenReturn(new Prova());
		when(respostaAluno2.getResposta()).thenReturn(LetraResposta.C);
		when(respostaAluno2.getPontuacao()).thenReturn(0);
		when(respostaAluno2.getQuestao()).thenReturn(questao2);

		RespostaAluno respostaAluno3 = mock(RespostaAluno.class);
		when(respostaAluno3.getAluno()).thenReturn(new Aluno());
		when(respostaAluno3.getProva()).thenReturn(new Prova());
		when(respostaAluno3.getResposta()).thenReturn(LetraResposta.D);
		when(respostaAluno3.getPontuacao()).thenReturn(Nivel.DIFICIL.getPontuacao());
		when(respostaAluno3.getQuestao()).thenReturn(questao2);

		List<RespostaAluno> respostasAlunos = java.util.Arrays.asList(respostaAluno1, respostaAluno2, respostaAluno3);

		int pontuacao = calculaNota.calcularNota(respostasAlunos);
		assertEquals(8, pontuacao);
	}

	@Test
	public void dadoRespostasDoAlunoDificeis_QuandoCalcularNova_RetornarTotalDeNotasDePerguntasDificeis() {
		Questao questao = mock(Questao.class);

		when(questao.getNivel()).thenReturn(Nivel.DIFICIL);

		RespostaAluno respostaAluno1 = mock(RespostaAluno.class);
		when(respostaAluno1.getAluno()).thenReturn(new Aluno());
		when(respostaAluno1.getProva()).thenReturn(new Prova());
		when(respostaAluno1.getResposta()).thenReturn(LetraResposta.A);
		when(respostaAluno1.getPontuacao()).thenReturn(Nivel.DIFICIL.getPontuacao());
		when(respostaAluno1.getQuestao()).thenReturn(questao);

		RespostaAluno respostaAluno2 = mock(RespostaAluno.class);
		when(respostaAluno2.getAluno()).thenReturn(new Aluno());
		when(respostaAluno2.getProva()).thenReturn(new Prova());
		when(respostaAluno2.getResposta()).thenReturn(LetraResposta.C);
		when(respostaAluno2.getPontuacao()).thenReturn(Nivel.DIFICIL.getPontuacao());
		when(respostaAluno2.getQuestao()).thenReturn(questao);

		RespostaAluno respostaAluno3 = mock(RespostaAluno.class);
		when(respostaAluno3.getAluno()).thenReturn(new Aluno());
		when(respostaAluno3.getProva()).thenReturn(new Prova());
		when(respostaAluno3.getResposta()).thenReturn(LetraResposta.D);
		when(respostaAluno3.getPontuacao()).thenReturn(Nivel.DIFICIL.getPontuacao());
		when(respostaAluno3.getQuestao()).thenReturn(questao);

		List<RespostaAluno> respostasAlunos = java.util.Arrays.asList(respostaAluno1, respostaAluno2, respostaAluno3);

		int pontuacao = calculaNota.calcularNota(respostasAlunos);
		assertEquals(72, pontuacao);
	}

	@Test
	public void dadoRespostasDoAlunoFaceis_QuandoCalcularNova_RetornarTotalDeNotasDePerguntasDificesComValorZero() {
		Questao questao = mock(Questao.class);

		when(questao.getNivel()).thenReturn(Nivel.FACIL);

		RespostaAluno respostaAluno1 = mock(RespostaAluno.class);
		when(respostaAluno1.getAluno()).thenReturn(new Aluno());
		when(respostaAluno1.getProva()).thenReturn(new Prova());
		when(respostaAluno1.getResposta()).thenReturn(LetraResposta.A);
		when(respostaAluno1.getPontuacao()).thenReturn(Nivel.FACIL.getPontuacao());
		when(respostaAluno1.getQuestao()).thenReturn(questao);

		RespostaAluno respostaAluno2 = mock(RespostaAluno.class);
		when(respostaAluno2.getAluno()).thenReturn(new Aluno());
		when(respostaAluno2.getProva()).thenReturn(new Prova());
		when(respostaAluno2.getResposta()).thenReturn(LetraResposta.C);
		when(respostaAluno2.getPontuacao()).thenReturn(Nivel.FACIL.getPontuacao());
		when(respostaAluno2.getQuestao()).thenReturn(questao);

		RespostaAluno respostaAluno3 = mock(RespostaAluno.class);
		when(respostaAluno3.getAluno()).thenReturn(new Aluno());
		when(respostaAluno3.getProva()).thenReturn(new Prova());
		when(respostaAluno3.getResposta()).thenReturn(LetraResposta.D);
		when(respostaAluno3.getPontuacao()).thenReturn(Nivel.FACIL.getPontuacao());
		when(respostaAluno3.getQuestao()).thenReturn(questao);

		List<RespostaAluno> respostasAlunos = java.util.Arrays.asList(respostaAluno1, respostaAluno2, respostaAluno3);

		int pontuacao = calculaNota.calcularNota(respostasAlunos);
		assertEquals(0, pontuacao);
	}

	@Test
	public void dadoRespostasDoAlunoNull_QuandoCalcularNova_RetornarTotalDeNotasDePerguntasFaceisComValorZero() {
		int pontuacao = calculaNota.calcularNota(null);
		assertEquals(0, pontuacao);
	}

	@Test
	public void dadoRespostasDoAlunoEmpty_QuandoCalcularNova_RetornarTotalDeNotasDePerguntasFaceisComValorZero() {
		int pontuacao = calculaNota.calcularNota(Collections.emptyList());
		assertEquals(0, pontuacao);
	}
}