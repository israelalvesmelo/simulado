package br.com.simulado.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import br.com.simulado.dto.RespondeQuestaoDto;
import br.com.simulado.dto.ResultadoQuestaoDto;
import br.com.simulado.modal.Aluno;
import br.com.simulado.modal.Gabarito;
import br.com.simulado.modal.LetraResposta;
import br.com.simulado.modal.Nivel;
import br.com.simulado.modal.Prova;
import br.com.simulado.modal.Questao;
import br.com.simulado.modal.Resposta;
import br.com.simulado.modal.RespostaAluno;
import br.com.simulado.modal.Simulado;
import br.com.simulado.repository.RespostaAlunoRepository;
import javassist.NotFoundException;

@SpringBootTest
public class RespostaAlunoServiceTest {
	private static final String CPF = "555666989898";

	private static final int NUMERO_QUESTAO = 1;

	private static final String PROVA = "Matematica";

	private static final String SIMULADO = "FATEC";

	@MockBean
	private SimuladoService simuladoService;

	@MockBean
	private RespostaAlunoRepository respostaAlunoRepository;

	@MockBean
	private AlunoService alunoService;
	
	@Autowired
	private RespostaAlunoService respostaAlunoService;
	
	@Test
	public void dadoValorNull_quandoSalvaRespostaAluno_retornarIllegalArgumentException() {
		RespondeQuestaoDto resposta = mock(RespondeQuestaoDto.class);
		Exception exception = assertThrows(IllegalArgumentException.class, () -> {
			respostaAlunoService.salvaRespostaAluno(SIMULADO, PROVA, NUMERO_QUESTAO, CPF, resposta);
		});

		String expectedMessage = "Resposta deve ser informada";
		String actualMessage = exception.getMessage();

		assertEquals(expectedMessage, actualMessage);
	
	}
	
	@Test
	public void dadoUmaRespostaCorreta_quandoSalvaRespostaAluno_retornarMensagem() throws NotFoundException {
		RespondeQuestaoDto respostaDto = mock(RespondeQuestaoDto.class);
		Simulado simulado = mock(Simulado.class);
		Aluno aluno = mock(Aluno.class);
		Prova prova = mock(Prova.class);
		Gabarito gabarito = mock(Gabarito.class);
		Resposta resposta = mock(Resposta.class);
		
		Optional<RespostaAluno> respostaAluno = Optional.empty();
		Questao questao = mock(Questao.class);
		
		when(questao.getNivel()).thenReturn(Nivel.FACIL);
		when(questao.getNumero()).thenReturn(NUMERO_QUESTAO);
		when(simuladoService.buscaSimuladoPeloNome(SIMULADO)).thenReturn(simulado);
		when(alunoService.buscaAlunoPorCpfESimulado(CPF, simulado)).thenReturn(aluno);
		when(simulado.retornaProvaPorNome(PROVA)).thenReturn(prova);
		when(prova.retornaQuestaoPorNumero(NUMERO_QUESTAO)).thenReturn(questao);
		when(prova.getGabarito()).thenReturn(gabarito);
		when(gabarito.retornaRespostaPeloNumeroQuestao(NUMERO_QUESTAO)).thenReturn(resposta);
		when(resposta.getResposta()).thenReturn(LetraResposta.A);
		when(respostaAlunoRepository.findByAlunoAndQuestao(aluno, questao)).thenReturn(respostaAluno);
		when(respostaDto.getResposta()).thenReturn(LetraResposta.A.getNome());


		ResultadoQuestaoDto resultadoQuestaoDto = respostaAlunoService.salvaRespostaAluno(SIMULADO, PROVA, NUMERO_QUESTAO, CPF, respostaDto);
		assertEquals("Resposta correta", resultadoQuestaoDto.getStatus());
		assertEquals(resposta.getResposta().getNome(), resultadoQuestaoDto.getResposta());
	
	}
	
	@Test
	public void dadoUmaRespostaIncorreta_quandoSalvaRespostaAluno_retornarMensagem() throws NotFoundException {
		RespondeQuestaoDto respostaDto = mock(RespondeQuestaoDto.class);
		Simulado simulado = mock(Simulado.class);
		Aluno aluno = mock(Aluno.class);
		Prova prova = mock(Prova.class);
		Gabarito gabarito = mock(Gabarito.class);
		Resposta resposta = mock(Resposta.class);
		
		Optional<RespostaAluno> respostaAluno = Optional.empty();
		Questao questao = mock(Questao.class);
		
		when(questao.getNivel()).thenReturn(Nivel.FACIL);
		when(questao.getNumero()).thenReturn(NUMERO_QUESTAO);
		when(simuladoService.buscaSimuladoPeloNome(SIMULADO)).thenReturn(simulado);
		when(alunoService.buscaAlunoPorCpfESimulado(CPF, simulado)).thenReturn(aluno);
		when(simulado.retornaProvaPorNome(PROVA)).thenReturn(prova);
		when(prova.retornaQuestaoPorNumero(NUMERO_QUESTAO)).thenReturn(questao);
		when(prova.getGabarito()).thenReturn(gabarito);
		when(gabarito.retornaRespostaPeloNumeroQuestao(NUMERO_QUESTAO)).thenReturn(resposta);
		when(resposta.getResposta()).thenReturn(LetraResposta.D);
		when(respostaAlunoRepository.findByAlunoAndQuestao(aluno, questao)).thenReturn(respostaAluno);
		when(respostaDto.getResposta()).thenReturn(LetraResposta.A.getNome());


		ResultadoQuestaoDto resultadoQuestaoDto = respostaAlunoService.salvaRespostaAluno(SIMULADO, PROVA, NUMERO_QUESTAO, CPF, respostaDto);
		assertEquals("Resposta incorreta", resultadoQuestaoDto.getStatus());
		assertEquals(LetraResposta.A.getNome(), resultadoQuestaoDto.getResposta());
	
	}
}
