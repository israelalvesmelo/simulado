package br.com.simulado.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.simulado.modal.Simulado;

@SpringBootTest
public class AlunoServiceTest {

	private static final String MENSAGEM_ERROR_CPF_SIMULADO = "CPF e simulado do aluno deve ser informado";
	private static final String MENSAGEM_ERROR_SIMULADO = "Simulado do aluno deve ser informado";

	@Autowired
	private AlunoService alunoService;

	@Test
	public void dadoCpfNull_quandoBuscaAlunoPorCpfESimulado_retornarIllegalArgumentException() {
		Simulado simulado = mock(Simulado.class);
		Exception exception = assertThrows(IllegalArgumentException.class, () -> {
			alunoService.buscaAlunoPorCpfESimulado(null, simulado);
		});

		String expectedMessage = MENSAGEM_ERROR_CPF_SIMULADO;
		String actualMessage = exception.getMessage();

		assertEquals(expectedMessage, actualMessage);
	}

	@Test
	public void dadoSimuladoNull_quandoBuscaAlunoPorCpfESimulado_retornarIllegalArgumentException() {
		Exception exception = assertThrows(IllegalArgumentException.class, () -> {
			alunoService.buscaAlunoPorCpfESimulado("55566699888", null);
		});

		String expectedMessage = MENSAGEM_ERROR_CPF_SIMULADO;
		String actualMessage = exception.getMessage();

		assertEquals(expectedMessage, actualMessage);
	}

	@Test
	public void dadoSimuladoNull_quandoBuscaAlunoPorSimulado_retornarIllegalArgumentException() {
		Exception exception = assertThrows(IllegalArgumentException.class, () -> {
			alunoService.buscaAlunoPorSimulado(null);
		});

		String expectedMessage = MENSAGEM_ERROR_SIMULADO;
		String actualMessage = exception.getMessage();

		assertEquals(expectedMessage, actualMessage);
	}
}
