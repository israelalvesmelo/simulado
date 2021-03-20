package br.com.simulado.dto;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.simulado.modal.Simulado;

public class SimuladoDto {
	private String nome;
	@JsonProperty(value = "provas")
	private List<ProvaDto> provasDto;

	public SimuladoDto(String nome, List<ProvaDto> provasDto) {
		this.nome = nome;
		this.provasDto = provasDto;
	}

	public SimuladoDto() {
		this.provasDto = new ArrayList<>();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<ProvaDto> getProvasDto() {
		return provasDto;
	}

	public void setProvasDto(List<ProvaDto> provasDto) {
		this.provasDto = provasDto;
	}

	public void addProvaDto(ProvaDto provaDto) {
		this.provasDto.add(provaDto);
	}

	public SimuladoDto criarSimuladoDtoPorSimulado(Simulado simulado) {
		SimuladoDto simuladoDto = new SimuladoDto();
		simuladoDto.setNome(simulado.getNome());
		simulado.getProvas().stream().forEach(p -> simuladoDto.addProvaDto(new ProvaDto(p)));

		return simuladoDto;
	}
}
