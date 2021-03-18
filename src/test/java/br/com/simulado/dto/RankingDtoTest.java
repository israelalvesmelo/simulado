package br.com.simulado.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.Test;

public class RankingDtoTest {

	@Test
	public void DadoUmaSequenciaDeAlunosQuandoCalculaRankingRetornaOsPrimeirosCincoComBaseNasNotas() {
		RankingDto rankingDto = new RankingDto();
		AlunoDto a1 = new AlunoDto("69680803031","Robson Souza", 1);
		AlunoDto a2 = new AlunoDto("69680803032", "Talita Silva", 10);
		AlunoDto a3 = new AlunoDto("69680803033","Felipe Luiz", 5);
		AlunoDto a4 = new AlunoDto("69680803034","Katia Alves", 2);
		AlunoDto a5 = new AlunoDto("69680803035","Henrique Melo", 9);
		AlunoDto a6 = new AlunoDto("69680803036","Marcelo Moreira", 9);
		AlunoDto a7 = new AlunoDto("69680803037","Fabiola Melo", 1);

		rankingDto.addAlunoDto(a1);
		rankingDto.addAlunoDto(a2);
		rankingDto.addAlunoDto(a3);
		rankingDto.addAlunoDto(a4);
		rankingDto.addAlunoDto(a5);
		rankingDto.addAlunoDto(a6);
		rankingDto.addAlunoDto(a7);

		assertEquals(5, rankingDto.getAlunos().size());
		
		assertEquals("69680803032", rankingDto.getAlunos().get(0).getCpf());
		assertEquals("Talita Silva", rankingDto.getAlunos().get(0).getNome());
		assertEquals(1, rankingDto.getAlunos().get(0).getRanking());
		
		assertEquals("69680803035", rankingDto.getAlunos().get(1).getCpf());
		assertEquals("Henrique Melo", rankingDto.getAlunos().get(1).getNome());		
		assertEquals(2, rankingDto.getAlunos().get(1).getRanking());
		
		assertEquals("69680803036", rankingDto.getAlunos().get(2).getCpf());
		assertEquals("Marcelo Moreira", rankingDto.getAlunos().get(2).getNome());		
		assertEquals(2, rankingDto.getAlunos().get(2).getRanking());
		
		assertEquals("69680803033", rankingDto.getAlunos().get(3).getCpf());
		assertEquals("Felipe Luiz", rankingDto.getAlunos().get(3).getNome());		
		assertEquals(4, rankingDto.getAlunos().get(3).getRanking());
		
		assertEquals("69680803034", rankingDto.getAlunos().get(4).getCpf());
		assertEquals(5, rankingDto.getAlunos().get(4).getRanking());
		assertEquals("Katia Alves", rankingDto.getAlunos().get(4).getNome());		


	}
}
