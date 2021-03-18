package br.com.simulado.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.simulado.dto.GabaritoDto;
import br.com.simulado.service.ProvaService;
import javassist.NotFoundException;

@RestController
public class ProvaController {
	
	@Autowired
	private ProvaService provaService;
	
	@RequestMapping(path = "{simulado}/{prova}/gabaritos", method=RequestMethod.GET)
	public ResponseEntity<GabaritoDto> buscaGabarito(@PathVariable("simulado") String simulado, @PathVariable("prova") String prova) throws NotFoundException {
			GabaritoDto gabaritoDto = provaService.buscaGabaritoPelaProva(simulado, prova);
			return new ResponseEntity<>(gabaritoDto, HttpStatus.OK);

		
	}
}
