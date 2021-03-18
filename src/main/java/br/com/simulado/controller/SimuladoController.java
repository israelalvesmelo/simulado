package br.com.simulado.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.simulado.dto.RankingDto;
import br.com.simulado.dto.SimuladoDto;
import br.com.simulado.service.SimuladoService;
import javassist.NotFoundException;


@RestController
@RequestMapping("/simulados")
public class SimuladoController {
	@Autowired
	private SimuladoService simuladoService;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<SimuladoDto>> buscaSimulados() {
		List<SimuladoDto> simuladosDto = simuladoService.buscaSimulados();
		
		return new ResponseEntity<>(simuladosDto, HttpStatus.OK);
	}
	
	@RequestMapping(path = "{simulado}/ranking", method = RequestMethod.GET)
	public ResponseEntity<RankingDto> geraRanking(@PathVariable("simulado") String simulado) throws NotFoundException {
		RankingDto ranking = simuladoService.calculaRanking(simulado);
		
		return new ResponseEntity<>(ranking, HttpStatus.OK);
	}
}
