package br.ufba.mata62.sistemaacademico.controller;

import java.text.Collator;
import java.util.Locale;

import br.ufba.mata62.sistemaacademico.domain.Aluno;
import br.ufba.mata62.sistemaacademico.domain.ComponenteCurricular;
import br.ufba.mata62.sistemaacademico.domain.ComponenteCurricularCursado;
import br.ufba.mata62.sistemaacademico.domain.Conceito;
import br.ufba.mata62.sistemaacademico.domain.Curso;
import br.ufba.mata62.sistemaacademico.domain.Disciplina;
import br.ufba.mata62.sistemaacademico.service.ImpressorCurriculoService;
import br.ufba.mata62.sistemaacademico.domain.ImpressorHistoricoHtml;
import br.ufba.mata62.sistemaacademico.domain.ImpressorHistoricoTxt;
import br.ufba.mata62.sistemaacademico.repository.LeitorDados;
import br.ufba.mata62.sistemaacademico.domain.PeriodoCursado;
import br.ufba.mata62.sistemaacademico.domain.Universidade;
import br.ufba.mata62.sistemaacademico.service.*;

public class Main {
	
	public static void main(String[] args){
		
		Universidade.setNome("Universidade Federal da Bahia");
		Universidade.setSigla("UFBA");
		
		LeitorDados leitorDados = new LeitorDados("dados.txt");
		leitorDados.lerDados();
	
		
		ImpressorHistoricoHtml html = new ImpressorHistoricoHtml();
		ImpressorHistoricoTxt txt = new ImpressorHistoricoTxt();
		
		System.out.println("Cursos da Universidade:");
		for(Curso curso : Universidade.getCursos().values()) {
			System.out.println("Curso: " + curso.getNome());
            ImpressorCurriculoService.imprimir(curso.getCurriculo());
			System.out.println();
		}
		
		System.out.println("Disciplinas da Universidade:");
		for(Disciplina disciplina : Universidade.getDisciplinas().values()) {
			System.out.println("Disciplina: " + disciplina.getNome());
			System.out.println("Codigo: " + disciplina.getCodigo());
			System.out.println("Carga Horaria: " + disciplina.getCargaHoraria());
			System.out.println();
		} 
		
		
		String cienciaDaComputacao = "CiENCIA DA COMPUTACAO - BACHARELADO  - SALVADOR";

		Curso c = null;

		Collator collator = Collator.getInstance (new Locale ("pt", "BR"));
		collator.setStrength(Collator.PRIMARY);

		for(Curso curso : Universidade.getCursos().values()) {
			if(collator.compare(cienciaDaComputacao, curso.getNome()) == 0) {
				c = curso;
			}
		}

		Aluno pabloHenrique = new Aluno("Pablo Henrique Rego dos Santos Cabral", 218115563, "2018.1", "123", c);

		try {
			UniversidadeService.insereAluno(218115563, pabloHenrique);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		PeriodoCursado pc = new PeriodoCursado("2018.1");
		pabloHenrique.getHistorico().inserePeriodoCursado(pc);

		for(ComponenteCurricular cc : pabloHenrique.getComponentesCurricularesObrigatorios(1)) {
			ComponenteCurricularCursado ccc = new ComponenteCurricularCursado(cc);
			pabloHenrique.insereComponenteCurricularCursado(1, ccc);
			ccc.setConceito(Conceito.APROVADO);
			ccc.setNota(5.0);
		}

		System.out.println("Alunos da Universidade:");
		for(Aluno aluno : Universidade.getAlunos().values()){
			System.out.println("Aluno: " + aluno.getNome());
			System.out.println("Matricula: " + aluno.getMatricula());
			HistoricoService.imprimir(html, aluno.getHistorico());
			System.out.println("OB: " + HistoricoService.calcularCargaHorariaObrigatorias(aluno.getHistorico()));
			System.out.println("OP: " + HistoricoService.calcularCargaHorariaOptativas(aluno.getHistorico()));
			System.out.println("CR: " + HistoricoService.calcularCoeficienteRendimento(aluno.getHistorico()));
			
			HistoricoService.imprimir(txt, aluno.getHistorico());
			System.out.println();
		}
	}
}
