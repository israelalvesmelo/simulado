package br.com.simulado.controller;

import static org.hamcrest.CoreMatchers.any;
import static org.hamcrest.CoreMatchers.anything;
import static org.mockito.Mockito.when;

import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import br.com.simulado.dto.AlunoDto;
import br.com.simulado.dto.ProvaDto;
import br.com.simulado.dto.RankingDto;
import br.com.simulado.dto.SimuladoDto;
import br.com.simulado.service.SimuladoService;

@WebMvcTest(controllers = SimuladoController.class)
public class SimuladoControllerTest {

	@MockBean
	private SimuladoService simuladoService;

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void dadoUmaSolicitacaoParaExibirOsSimulados_QuandoBuscaSimulados_RetornarOk() throws Exception {
		SimuladoDto simuladoDto = new SimuladoDto();
		simuladoDto.setNome("FATEC");
		ProvaDto provaDto = new ProvaDto();
		provaDto.setNome("Matematica");
		simuladoDto.setProvasDto(Arrays.asList(provaDto));

		when(simuladoService.buscaSimulados()).thenReturn((Arrays.asList(simuladoDto)));
		mockMvc.perform(MockMvcRequestBuilders.get("/simulados")).andExpect(MockMvcResultMatchers.status().isOk())
					.andExpect(MockMvcResultMatchers.content()
							.json(JsonParse.converteObjetoParaJson(Arrays.asList(simuladoDto))));

	}
	
	@Test
	public void dadoUmaSolicitacaoParaGerarRanking_QuandoGeraRanking_RetornarRanking()
			throws Exception {
		RankingDto rankingDto = new RankingDto();
		AlunoDto a1 = new AlunoDto("Robson Souza", 1);
		rankingDto.addAlunoDto(a1);
		
		when(simuladoService.calculaRanking("FATEC")).thenReturn(rankingDto);
		
		mockMvc.perform(MockMvcRequestBuilders.get("/simulados/{simulado}/ranking", "FATEC"))
		.andExpect(MockMvcResultMatchers.status().isOk())
		.andExpect(MockMvcResultMatchers.content().json(JsonParse.converteObjetoParaJson(rankingDto)));
	}

	@Test
	public void dadoUmaSolicitacaoParaGerarRankingSemPathSimulado_QuandoGeraRanking_RetornarNotFound()
			throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/simulados/{simulado}/ranking", null, null))
				.andExpect(MockMvcResultMatchers.status().isNotFound());

	}

}
