package br.com.simulado.modal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "nota_prova")
public class NotaProva {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@OneToOne
	private Prova prova;
	private int nota;
	@ManyToOne
	private Aluno aluno;

	public NotaProva() {
	}

	public NotaProva(Prova prova, int nota) {
		this.prova = prova;
		this.nota = nota;
	}

	public Prova getProva() {
		return prova;
	}

	public void setProva(Prova prova) {
		this.prova = prova;
	}

	public int getNota() {
		return nota;
	}

	public void setNota(int nota) {
		this.nota = nota;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}
}
