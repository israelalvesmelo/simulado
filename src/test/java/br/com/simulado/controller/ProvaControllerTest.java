package br.com.simulado.controller;

import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import br.com.simulado.dto.GabaritoDto;
import br.com.simulado.dto.QuestaoDto;
import br.com.simulado.dto.RespostaDto;
import br.com.simulado.modal.LetraResposta;
import br.com.simulado.modal.Nivel;
import br.com.simulado.service.ProvaService;

@WebMvcTest(controllers = ProvaController.class)
public class ProvaControllerTest {

	@MockBean
	private ProvaService provaService;

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void dadoUmaSolicitacaoDeGabarito_QuandoBuscaGabaritoPelaProva_RetornarGabaritoDto() throws Exception {
		QuestaoDto questaoDto = new QuestaoDto();
		questaoDto.setDescricao("Qual o valor da conta: 5 + 10 ?");
		questaoDto.setNivel(Nivel.FACIL.getNome());
		questaoDto.setNumero(1);

		RespostaDto respostaDto = new RespostaDto();
		respostaDto.setResposta(LetraResposta.A);
		respostaDto.setQuestao(questaoDto);

		GabaritoDto gabaritoDto = new GabaritoDto(java.util.Arrays.asList(respostaDto));

		when(provaService.buscaGabaritoPelaProva("FATEC", "Matematica")).thenReturn(gabaritoDto);

		mockMvc.perform(MockMvcRequestBuilders.get("/{simulado}/{prova}/gabaritos", "FATEC", "Matematica"))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.content().json(JsonParse.converteObjetoParaJson(gabaritoDto)));
	}

	@Test
	public void dadoUmaSolicitacaoDeGabaritoSemPathSimulado_QuandoBuscaGabaritoPelaProva_RetornarNotFound()
			throws Exception {

		mockMvc.perform(MockMvcRequestBuilders.get("/{simulado}/{prova}/gabaritos", null, "Matematica"))
				.andExpect(MockMvcResultMatchers.status().isNotFound());
	}

	@Test
	public void dadoUmaSolicitacaoDeGabaritoSemPathProva_QuandoBuscaGabaritoPelaProva_RetornarNotFound()
			throws Exception {

		mockMvc.perform(MockMvcRequestBuilders.get("/{simulado}/{prova}/gabaritos", "FATEC", null))
				.andExpect(MockMvcResultMatchers.status().isNotFound());
	}

	@Test
	public void dadoUmaSolicitacaoDeGabaritoSemPaths_QuandoBuscaGabaritoPelaProva_RetornarNotFound() throws Exception {

		mockMvc.perform(MockMvcRequestBuilders.get("/{simulado}/{prova}/gabaritos", null, null))
				.andExpect(MockMvcResultMatchers.status().isNotFound());
	}

}
