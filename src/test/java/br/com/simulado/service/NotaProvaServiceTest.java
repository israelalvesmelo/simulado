package br.com.simulado.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import br.com.simulado.modal.Aluno;
import br.com.simulado.modal.LetraResposta;
import br.com.simulado.modal.Nivel;
import br.com.simulado.modal.NotaProva;
import br.com.simulado.modal.Prova;
import br.com.simulado.modal.Questao;
import br.com.simulado.modal.RespostaAluno;
import br.com.simulado.repository.NotaProvaRepository;
import javassist.NotFoundException;

@SpringBootTest
public class NotaProvaServiceTest {
	@MockBean
	private NotaProvaRepository notaProvaRepository;
	
	@MockBean
	private RespostaAlunoService respostaAlunoService;
	
	@Autowired
	private NotaProvaService notaProvaService;
	
	@Test
	public void dadoAlunoSemRespostas_quandoCalculaNotaProva_EntaoRetornarNotaProvaPadrao() throws NotFoundException {
		Aluno aluno = mock(Aluno.class);
		Prova prova = mock(Prova.class);
		Optional<NotaProva> notaProva = Optional.of(new NotaProva());
		Optional<List<RespostaAluno>> respostaAluno = Optional.empty();
		
		when(respostaAlunoService.buscaRespostaAlunoPeloAlunoProva(aluno,
				prova)).thenReturn(respostaAluno);
		when(notaProvaRepository.findByAlunoAndProva(aluno, prova)).thenReturn(notaProva);
		when(notaProvaRepository.save(notaProva.get())).thenReturn(notaProva.get());
		
		Optional<NotaProva> notaProvaResultado = notaProvaService.calculaNotaProva(aluno, prova);
		
		assertEquals(600, notaProvaResultado.get().getNota());
	}
	
	@Test
	public void dadoAlunoComRespostas_quandoCalculaNotaProva_EntaoRetornarNotaProvaCalculada() throws NotFoundException {
		Aluno aluno = mock(Aluno.class);
		Prova prova = mock(Prova.class);
		Questao questao1 = mock(Questao.class);
		Questao questao2 = mock(Questao.class);

		when(questao1.getNivel()).thenReturn(Nivel.FACIL);
		when(questao2.getNivel()).thenReturn(Nivel.MEDIA);
		
		RespostaAluno respostaAluno1 = mock(RespostaAluno.class);
		when(respostaAluno1.getAluno()).thenReturn(new Aluno());
		when(respostaAluno1.getProva()).thenReturn(new Prova());
		when(respostaAluno1.getResposta()).thenReturn(LetraResposta.A);
		when(respostaAluno1.getPontuacao()).thenReturn(Nivel.FACIL.getPontuacao());
		when(respostaAluno1.getQuestao()).thenReturn(questao1);

		RespostaAluno respostaAluno2 = mock(RespostaAluno.class);
		when(respostaAluno2.getAluno()).thenReturn(new Aluno());
		when(respostaAluno2.getProva()).thenReturn(new Prova());
		when(respostaAluno2.getResposta()).thenReturn(LetraResposta.C);
		when(respostaAluno2.getPontuacao()).thenReturn(Nivel.DIFICIL.getPontuacao());
		when(respostaAluno2.getQuestao()).thenReturn(questao2);
		
		Optional<NotaProva> notaProva = Optional.of(new NotaProva());
		Optional<List<RespostaAluno>> respostaAluno = Optional.of(Arrays.asList(respostaAluno1, respostaAluno2));
		
		when(respostaAlunoService.buscaRespostaAlunoPeloAlunoProva(aluno,
				prova)).thenReturn(respostaAluno);
		when(notaProvaRepository.findByAlunoAndProva(aluno, prova)).thenReturn(notaProva);
		when(notaProvaRepository.save(notaProva.get())).thenReturn(notaProva.get());
		
		Optional<NotaProva> notaProvaResultado = notaProvaService.calculaNotaProva(aluno, prova);
		
		assertEquals(623, notaProvaResultado.get().getNota());
	}
}
