package br.com.simulado.dto;

import java.util.ArrayList;
import java.util.List;

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
		if (alunoDto == null) {
			return;
		}

		if (this.alunos.isEmpty()) {
			alunoDto.setRanking(1);
			this.alunos.add(alunoDto);
			return;
		}

		List<AlunoDto> aux = this.alunos;

		for (int i = aux.size() - 1; i >= 0; i--) {
			AlunoDto alunoAux = aux.get(i);
			if (alunoDto.getNota() > alunoAux.getNota()) {
				substituiPosicao(alunoDto, alunoAux);
			} else if (alunoDto.getNota() == alunoAux.getNota()) {
				empatePosicao(alunoDto, alunoAux);
			} else if (alunoDto.getNota() < alunoAux.getNota() && !temValorMenor(alunoAux.getNota())) {
				menorPosicao(alunoDto, alunoAux);
			}

		}

		this.alunos.sort((a1, a2) -> a2.getNota().compareTo(a1.getNota()));
		verificaSomenteTopCincoPosicoes();
	}

	private void verificaSomenteTopCincoPosicoes() {
		if (this.alunos.size() > 5) {
			this.alunos.remove(5);
		}
	}

	private void menorPosicao(AlunoDto alunoDto, AlunoDto alunoAux) {
		alunoDto.setRanking(alunoAux.getRanking() + 1);
		this.alunos.add(alunoDto);
	}

	private void empatePosicao(AlunoDto alunoDto, AlunoDto alunoAux) {
		this.alunos.remove(alunoAux);
		this.alunos.remove(alunoDto);
		alunoDto.setRanking(alunoAux.getRanking());
		this.alunos.add(alunoAux);
		this.alunos.add(alunoDto);
	}

	private void substituiPosicao(AlunoDto alunoDto, AlunoDto alunoAux) {
		this.alunos.remove(alunoDto);
		alunoDto.setRanking(alunoAux.getRanking());
		this.alunos.add(alunoDto);
		this.alunos.remove(alunoAux);
		menorPosicao(alunoAux, alunoAux);
	}

	private boolean temValorMenor(Integer nota) {
		return this.alunos.stream().anyMatch(a -> (a.getNota() < nota));
	}

}
