package br.com.simulado.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class RankingDtoTest {

	@Test
	public void dadoUmaSequenciaDeAlunos_QuandoCalculaRanking_RetornarOsPrimeirosCincoComBaseNasNotas() {
		RankingDto rankingDto = new RankingDto();
		AlunoDto a1 = new AlunoDto("Robson Souza", 1);
		AlunoDto a2 = new AlunoDto("Talita Silva", 10);
		AlunoDto a3 = new AlunoDto("Felipe Luiz", 5);
		AlunoDto a4 = new AlunoDto("Katia Alves", 2);
		AlunoDto a5 = new AlunoDto("Henrique Melo", 9);
		AlunoDto a6 = new AlunoDto("Marcelo Moreira", 9);
		AlunoDto a7 = new AlunoDto("Fabiola Melo", 1);

		rankingDto.addAlunoDto(a1);
		rankingDto.addAlunoDto(a2);
		rankingDto.addAlunoDto(a3);
		rankingDto.addAlunoDto(a4);
		rankingDto.addAlunoDto(a5);
		rankingDto.addAlunoDto(a6);
		rankingDto.addAlunoDto(a7);

		assertEquals(5, rankingDto.getAlunos().size());

		assertEquals("Talita Silva", rankingDto.getAlunos().get(0).getNome());
		assertEquals(1, rankingDto.getAlunos().get(0).getRanking());

		assertEquals("Henrique Melo", rankingDto.getAlunos().get(1).getNome());
		assertEquals(2, rankingDto.getAlunos().get(1).getRanking());

		assertEquals("Marcelo Moreira", rankingDto.getAlunos().get(2).getNome());
		assertEquals(2, rankingDto.getAlunos().get(2).getRanking());

		assertEquals("Felipe Luiz", rankingDto.getAlunos().get(3).getNome());
		assertEquals(4, rankingDto.getAlunos().get(3).getRanking());

		assertEquals(5, rankingDto.getAlunos().get(4).getRanking());
		assertEquals("Katia Alves", rankingDto.getAlunos().get(4).getNome());

	}

	@Test
	public void dadoUmaSequenciaDeAlunosComMesmaNota_QuandoCalculaRanking_RetornarTodosComNaPrimeiraPosicao() {
		RankingDto rankingDto = new RankingDto();
		AlunoDto a1 = new AlunoDto("Robson Souza", 7);
		AlunoDto a2 = new AlunoDto("Talita Silva", 7);
		AlunoDto a3 = new AlunoDto("Felipe Luiz", 7);
		AlunoDto a4 = new AlunoDto("Katia Alves", 7);
		AlunoDto a5 = new AlunoDto("Henrique Melo", 7);
		AlunoDto a6 = new AlunoDto("Marcelo Moreira", 7);

		rankingDto.addAlunoDto(a1);
		rankingDto.addAlunoDto(a2);
		rankingDto.addAlunoDto(a3);
		rankingDto.addAlunoDto(a4);
		rankingDto.addAlunoDto(a5);
		rankingDto.addAlunoDto(a6);

		assertEquals(5, rankingDto.getAlunos().size());

		assertEquals("Henrique Melo", rankingDto.getAlunos().get(0).getNome());
		assertEquals(1, rankingDto.getAlunos().get(0).getRanking());

		assertEquals("Felipe Luiz", rankingDto.getAlunos().get(1).getNome());
		assertEquals(1, rankingDto.getAlunos().get(1).getRanking());

		assertEquals("Robson Souza", rankingDto.getAlunos().get(2).getNome());
		assertEquals(1, rankingDto.getAlunos().get(2).getRanking());

		assertEquals("Talita Silva", rankingDto.getAlunos().get(3).getNome());
		assertEquals(1, rankingDto.getAlunos().get(3).getRanking());

		assertEquals(1, rankingDto.getAlunos().get(4).getRanking());
		assertEquals("Katia Alves", rankingDto.getAlunos().get(4).getNome());
	}

	@Test
	public void dadoUmAlunoComValorNull_QuandoCalculaRanking_RetornarListaDeRankingVazia() {
		RankingDto rankingDto = new RankingDto();
		AlunoDto a1 = null;

		rankingDto.addAlunoDto(a1);

		assertEquals(0, rankingDto.getAlunos().size());

	}

	@Test
	public void dadoUmUnicoAluno_QuandoCalculaRanking_RetornarAlunoEmPrimeiroLugar() {
		RankingDto rankingDto = new RankingDto();
		AlunoDto a1 = new AlunoDto("Henrique Melo", 7);

		rankingDto.addAlunoDto(a1);

		assertEquals(1, rankingDto.getAlunos().size());

		assertEquals("Henrique Melo", rankingDto.getAlunos().get(0).getNome());
		assertEquals(1, rankingDto.getAlunos().get(0).getRanking());

	}
}
