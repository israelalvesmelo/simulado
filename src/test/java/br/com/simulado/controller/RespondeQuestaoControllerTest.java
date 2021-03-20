package br.com.simulado.controller;

import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import br.com.simulado.dto.RespondeQuestaoDto;
import br.com.simulado.dto.ResultadoQuestaoDto;
import br.com.simulado.service.RespostaAlunoService;

@WebMvcTest(controllers = RespondeQuestaoController.class)
public class RespondeQuestaoControllerTest {

	private static final String CPF = "112233665544778";

	private static final String NUMERO_QUESTAO = "1";

	private static final String PROVA = "Matematica";

	private static final String SIMULADO = "FATEC";

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private RespostaAlunoService respondeService;

	@Test
	public void dadoUmaSolicitacaoParaResponderUmaQuestao_QuandoRespondeQuestao_RetornarOk() throws Exception {
		ResultadoQuestaoDto resultadoQuestaoDto = new ResultadoQuestaoDto();
		resultadoQuestaoDto.setResposta("A");
		resultadoQuestaoDto.setStatus("Resposta correta");

		RespondeQuestaoDto respondeQuestaoDto = new RespondeQuestaoDto();
		respondeQuestaoDto.setResposta("A");

		when(respondeService.respondeQuestao(SIMULADO, PROVA, Integer.valueOf(NUMERO_QUESTAO), CPF, respondeQuestaoDto))
				.thenReturn(resultadoQuestaoDto);

		mockMvc.perform(MockMvcRequestBuilders.post("/{simulado}/{prova}/{questao}", SIMULADO, PROVA, NUMERO_QUESTAO)
				.accept(MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON).queryParam("cpf", CPF)
				.content(JsonParse.converteObjetoParaJson(respondeQuestaoDto)))
				.andExpect(MockMvcResultMatchers.status().isCreated());
	}

	@Test
	public void dadoUmaSolicitacaoParaResponderUmaQuestaoSemParametroCPF_QuandoRespondeQuestao_RetornarBadRequest()
			throws Exception {

		RespondeQuestaoDto respondeQuestaoDto = new RespondeQuestaoDto();
		respondeQuestaoDto.setResposta("A");

		mockMvc.perform(MockMvcRequestBuilders.post("/{simulado}/{prova}/{questao}", SIMULADO, PROVA, NUMERO_QUESTAO)
				.accept(MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON)
				.content(JsonParse.converteObjetoParaJson(respondeQuestaoDto)))
				.andExpect(MockMvcResultMatchers.status().isBadRequest());
	}

	@Test
	public void dadoUmaSolicitacaoParaResponderUmaQuestaoSemPathSimulado_QuandoRespondeQuestao_RetornarNotFound()
			throws Exception {

		RespondeQuestaoDto respondeQuestaoDto = new RespondeQuestaoDto();
		respondeQuestaoDto.setResposta("A");

		mockMvc.perform(MockMvcRequestBuilders.post("/{simulado}/{prova}/{questao}", null, PROVA, NUMERO_QUESTAO)
				.accept(MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON).queryParam("cpf", CPF)
				.content(JsonParse.converteObjetoParaJson(respondeQuestaoDto)))
				.andExpect(MockMvcResultMatchers.status().isNotFound());
	}

	@Test
	public void dadoUmaSolicitacaoParaResponderUmaQuestaoSemPathProva_QuandoRespondeQuestao_RetornarNotFound()
			throws Exception {

		RespondeQuestaoDto respondeQuestaoDto = new RespondeQuestaoDto();
		respondeQuestaoDto.setResposta("A");

		mockMvc.perform(MockMvcRequestBuilders.post("/{simulado}/{prova}/{questao}", SIMULADO, null, NUMERO_QUESTAO)
				.accept(MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON).queryParam("cpf", CPF)
				.content(JsonParse.converteObjetoParaJson(respondeQuestaoDto)))
				.andExpect(MockMvcResultMatchers.status().isNotFound());
	}

	@Test
	public void dadoUmaSolicitacaoParaResponderUmaQuestaoSemPathNumeroQuestao_QuandoRespondeQuestao_RetornarNotFound()
			throws Exception {

		RespondeQuestaoDto respondeQuestaoDto = new RespondeQuestaoDto();
		respondeQuestaoDto.setResposta("A");

		mockMvc.perform(MockMvcRequestBuilders.post("/{simulado}/{prova}/{questao}", SIMULADO, PROVA, null)
				.accept(MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON).queryParam("cpf", CPF)
				.content(JsonParse.converteObjetoParaJson(respondeQuestaoDto)))
				.andExpect(MockMvcResultMatchers.status().isNotFound());
	}

	@Test
	public void dadoUmaSolicitacaoParaResponderUmaQuestaoSemContent_QuandoRespondeQuestao_RetornarNotFound()
			throws Exception {

		RespondeQuestaoDto respondeQuestaoDto = new RespondeQuestaoDto();
		respondeQuestaoDto.setResposta("A");

		mockMvc.perform(MockMvcRequestBuilders.post("/{simulado}/{prova}/{questao}", SIMULADO, PROVA, NUMERO_QUESTAO)
				.accept(MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON).queryParam("cpf", CPF))
				.andExpect(MockMvcResultMatchers.status().isBadRequest());
	}
	
	@Test
	public void dadoUmaSolicitacaoParaResponderUmaQuestaoComPathNumeroQuestaoComLetra_QuandoRespondeQuestao_RetornarNotFound()
			throws Exception {

		RespondeQuestaoDto respondeQuestaoDto = new RespondeQuestaoDto();
		respondeQuestaoDto.setResposta("A");

		mockMvc.perform(MockMvcRequestBuilders.post("/{simulado}/{prova}/{questao}", SIMULADO, PROVA, "d")
				.accept(MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON).queryParam("cpf", CPF)
				.content(JsonParse.converteObjetoParaJson(respondeQuestaoDto)))
				.andExpect(MockMvcResultMatchers.status().isBadRequest());
	}
}
