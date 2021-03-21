package br.com.simulado.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import br.com.simulado.dto.RankingDto;
import br.com.simulado.modal.Aluno;
import br.com.simulado.modal.NotaProva;
import br.com.simulado.modal.Prova;
import br.com.simulado.modal.Simulado;
import br.com.simulado.repository.SimuladoRepository;
import javassist.NotFoundException;

@SpringBootTest
public class SimuladoServiceTest {

	@MockBean
	private SimuladoRepository simuladoRepository;

	@MockBean
	private AlunoService alunoService;

	@MockBean
	private NotaProvaService notaProvaService;

	@Autowired
	private SimuladoService simuladoService;

	private static final String PROVA = "Matematica";

	private static final String SIMULADO = "FATEC";

	@Test
	public void dadoValorSimuladoInexistente_quandoCalculaRanking_thenNotFoundException() {

		when(simuladoRepository.findByNome(SIMULADO)).thenReturn(null);
		Exception exception = assertThrows(NotFoundException.class, () -> {
			simuladoService.calculaRanking(SIMULADO);
		});

		String expectedMessage = "Simulado [FATEC] não foi encontrado";
		String actualMessage = exception.getMessage();

		assertEquals(expectedMessage, actualMessage);
	}

	@Test
	public void dadoValorSimulado_quandoCalculaRanking_thenRanking() throws NotFoundException {
		Simulado simulado = mock(Simulado.class);
		Aluno aluno1 = mock(Aluno.class);
		Aluno aluno2 = mock(Aluno.class);
		Prova prova1 = mock(Prova.class);
		Prova prova2 = mock(Prova.class);

		Optional<NotaProva> notaProva1 = Optional.of(new NotaProva(prova1, 15));
		Optional<NotaProva> notaProva2 = Optional.of(new NotaProva(prova1, 8));
		Optional<NotaProva> notaProva3 = Optional.of(new NotaProva(prova2, 60));
		Optional<NotaProva> notaProva4 = Optional.of(new NotaProva(prova2, 90));

		when(simuladoRepository.findByNome(SIMULADO)).thenReturn(simulado);
		when(simulado.getProvas()).thenReturn(Arrays.asList(prova1, prova2));
		when(alunoService.buscaAlunoPorSimulado(simulado)).thenReturn(Arrays.asList(aluno1, aluno2));
		String ALUNO1 = "Robson Souza";
		String ALUNO2 = "Talita Silva";
		when(aluno1.getNome()).thenReturn(ALUNO1);
		when(aluno2.getNome()).thenReturn(ALUNO2);
		when(notaProvaService.calculaNotaProva(aluno1, prova1)).thenReturn(notaProva1);
		when(notaProvaService.calculaNotaProva(aluno1, prova2)).thenReturn(notaProva3);
		when(notaProvaService.calculaNotaProva(aluno2, prova1)).thenReturn(notaProva2);
		when(notaProvaService.calculaNotaProva(aluno2, prova2)).thenReturn(notaProva4);

		RankingDto rankingDto = simuladoService.calculaRanking(SIMULADO);

		assertEquals(2, rankingDto.getAlunos().size());

		assertEquals(1, rankingDto.getAlunos().get(0).getRanking());
		assertEquals(98, rankingDto.getAlunos().get(0).getNota());
		assertEquals(ALUNO2, rankingDto.getAlunos().get(0).getNome());

		assertEquals(2, rankingDto.getAlunos().get(1).getRanking());
		assertEquals(75, rankingDto.getAlunos().get(1).getNota());
		assertEquals(ALUNO1, rankingDto.getAlunos().get(1).getNome());
	}
}
