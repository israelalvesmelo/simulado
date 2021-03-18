package br.com.simulado.dto;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.simulado.modal.Gabarito;

public class GabaritoDto {

	@JsonProperty(value = "respostas")
	private List<RespostaDto> respostas;

	public GabaritoDto() {
		this.respostas = new ArrayList<>();
	}
	
	public GabaritoDto(Gabarito gabarito) {
		this();
		gabarito.getRespostas().forEach(r -> this.respostas.add(new RespostaDto(r)));
	}

	public GabaritoDto(List<RespostaDto> respostas) {
		this.respostas = respostas;
	}

	public List<RespostaDto> getRespostas() {
		return respostas;
	}

	public void setRespostas(List<RespostaDto> respostas) {
		this.respostas = respostas;
	}
		
}
