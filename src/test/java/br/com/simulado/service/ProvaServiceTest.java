package br.com.simulado.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import br.com.simulado.dto.GabaritoDto;
import br.com.simulado.modal.Gabarito;
import br.com.simulado.modal.LetraResposta;
import br.com.simulado.modal.Nivel;
import br.com.simulado.modal.Prova;
import br.com.simulado.modal.Questao;
import br.com.simulado.modal.Resposta;
import br.com.simulado.modal.Simulado;
import javassist.NotFoundException;

@SpringBootTest
public class ProvaServiceTest {

	private static final String PROVA = "Matematica";
	private static final String SIMULADO = "FATEC";
	
	@MockBean
	private SimuladoService simuladoService;

	@Autowired
	private ProvaService provaService;
	
	
	@Test
	public void dadoUmSimuladoEUmaProva_quandoBuscaGabaritoPelaProva_retornarGabaritoDto() throws NotFoundException {
		Simulado simulado = mock(Simulado.class);
		Prova prova = mock(Prova.class);
		Gabarito gabarito = mock(Gabarito.class);
		String descricao = "Descrição teste";
		
		Questao questao1 = new Questao(descricao, 1, Nivel.FACIL);
		Questao questao2 = new Questao(descricao, 2, Nivel.MEDIA);
		Questao questao3 = new Questao(descricao, 3, Nivel.DIFICIL);
		Resposta resposta1 = new Resposta(questao1, LetraResposta.A, gabarito);
		Resposta resposta2 = new Resposta(questao2, LetraResposta.B, gabarito);
		Resposta resposta3 = new Resposta(questao3, LetraResposta.C, gabarito);

		when(prova.getGabarito()).thenReturn(gabarito);
		when(gabarito.getRespostas()).thenReturn(Arrays.asList(resposta1, resposta2, resposta3));
		when(simulado.retornaProvaPorNome(PROVA)).thenReturn(prova);
		when(simuladoService.buscaSimuladoPeloNome(SIMULADO)).thenReturn(simulado);	
		
		GabaritoDto gabaritoDto = provaService.buscaGabaritoPelaProva(SIMULADO, PROVA);
		assertEquals(LetraResposta.A, gabaritoDto.getRespostas().get(0).getResposta());
		assertEquals(LetraResposta.B, gabaritoDto.getRespostas().get(1).getResposta());
		assertEquals(LetraResposta.C, gabaritoDto.getRespostas().get(2).getResposta());

	}
	
}
