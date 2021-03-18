package br.com.simulado.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.simulado.dto.GabaritoDto;
import br.com.simulado.modal.Prova;
import br.com.simulado.modal.Simulado;
import javassist.NotFoundException;

@Service
public class ProvaService {
	
	@Autowired
	private SimuladoService simuladoService;

	public GabaritoDto buscaGabaritoPelaProva(String nomeSimulado, String nomeProva) throws NotFoundException {
		Simulado simulado = this.simuladoService.buscaSimuladoPeloNome(nomeSimulado);
		Prova prova = simulado.retornaProvaPorNome(nomeProva);
		GabaritoDto gabaritoDto = new GabaritoDto(prova.getGabarito());
		return gabaritoDto;
	}
	

}
