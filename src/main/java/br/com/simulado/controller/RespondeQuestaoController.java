package br.com.simulado.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.simulado.dto.RespondeQuestaoDto;
import br.com.simulado.dto.ResultadoQuestaoDto;
import br.com.simulado.service.RespostaAlunoService;
import javassist.NotFoundException;

@RestController
public class RespondeQuestaoController {
	@Autowired
	private RespostaAlunoService respondeService;
	
	@RequestMapping(path = "{simulado}/{prova}/{questao}", method = RequestMethod.POST)
	public ResponseEntity<ResultadoQuestaoDto> respondeQuestao(@PathVariable("simulado") String nomeSimulado,
									  @PathVariable("prova") String nomeProva,
									  @PathVariable("questao") int numeroQuestao,
									  @RequestParam("cpf") String cpf,
									  @RequestBody RespondeQuestaoDto respondeQuestaoDto) throws NotFoundException {
	
		ResultadoQuestaoDto resultado = respondeService.respondeQuestao(nomeSimulado, nomeProva, numeroQuestao, cpf, respondeQuestaoDto);
		return new ResponseEntity<ResultadoQuestaoDto>(resultado, HttpStatus.CREATED);
	}
}
