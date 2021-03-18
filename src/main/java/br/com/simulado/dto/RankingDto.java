package br.com.simulado.dto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class RankingDto {
	private List<AlunoDto> alunos;

	public RankingDto() {
		this.alunos = new ArrayList<>();
	}

	public RankingDto(List<AlunoDto> alunos) {
		this.alunos = alunos;
	}

	public List<AlunoDto> getAlunos() {
		return alunos;
	}

	public void addAlunoDto(AlunoDto alunoDto) {
		if(this.alunos.isEmpty()) {
			alunoDto.setRanking(1);
			this.alunos.add(alunoDto);
			return;
		}
		List<AlunoDto> aux = this.alunos;

		for (int i = aux.size()-1; i >= 0; i--) {
			AlunoDto alunoAux = aux.get(i);
			if (alunoDto.getNota() > alunoAux.getNota()) {
				this.alunos.remove(alunoDto);
				alunoDto.setRanking(alunoAux.getRanking());
				this.alunos.add(alunoDto);
				this.alunos.remove(alunoAux);
				alunoAux.setRanking(alunoAux.getRanking() + 1);
				this.alunos.add(alunoAux);
			} else if (alunoDto.getNota() == alunoAux.getNota()) {
				this.alunos.remove(alunoAux);
				this.alunos.remove(alunoDto);
				alunoDto.setRanking(alunoAux.getRanking());
				this.alunos.add(alunoAux);

				this.alunos.add(alunoDto);
			} else if (alunoDto.getNota() < alunoAux.getNota() && !temValorMenor(alunoAux.getNota())) {
				// Procurar se tem valor menor, pegar e add o ranking agregando valor
				alunoDto.setRanking(alunoAux.getRanking() + 1);
				this.alunos.add(alunoDto);
			}
	
		}
		this.alunos.sort((a1, a2) -> a2.getNota().compareTo(a1.getNota()));
		if (this.alunos.size() > 5) {
			this.alunos.remove(5);
		}

	}

	private boolean temValorMaior(Integer nota) {
		return this.alunos.stream().anyMatch(a -> (a.getNota() > nota));
	}

	private Optional<AlunoDto> temValoIgual(Integer nota) {
		return this.alunos.stream().filter(a -> (a.getNota() == nota)).findFirst();
	}

	private boolean temValorMenor(Integer nota) {
		return this.alunos.stream().anyMatch(a -> (a.getNota() < nota));
	}
	
	private void diminuiClassificacao(String cpf) {
		this.alunos.stream().filter(a -> (a.getCpf().equals(cpf))).forEach(a -> a.setRanking(a.getRanking() + 1));
	}
}
