package br.ufba.mata62.sistemaacademico;

import java.text.Collator;
import java.util.Locale;

public class Main {
	
	public static void main(String[] args){
		
		Universidade universidade = new Universidade("Universidade Federal da Bahia", "UFBA");
		
		LeitorDados leitorDados = new LeitorDados("dados.txt", universidade);
		leitorDados.lerDados();
		
		System.out.println("Cursos da Universidade:");
		for(Curso curso : universidade.getCursos()) {
			System.out.println("Curso: " + curso.getNome());
			curso.getCurriculo().imprimir();
			System.out.println();
		}
		
		System.out.println("Disciplinas da Universidade:");
		for(Disciplina disciplina : universidade.getDisciplinas()) {
			System.out.println("Disciplina: " + disciplina.getNome());
			System.out.println("Codigo: " + disciplina.getCodigo());
			System.out.println("Carga Horaria: " + disciplina.getCargaHoraria());
			System.out.println();
		} 
		
		
		String cienciaDaComputacao = "Ci NCIA DA COMPUTA«√O - BACHARELADO  - SALVADOR";
		
		Curso c = null;
		
		Collator collator = Collator.getInstance (new Locale ("pt", "BR"));
		collator.setStrength(Collator.PRIMARY);
		
		for(Curso curso : universidade.getCursos()) {
			if(collator.compare(cienciaDaComputacao, curso.getNome()) == 0) {
				c = curso;
			}
		}
		
		Aluno pabloHenrique = new Aluno("Pablo Henrique Rego dos Santos Cabral", 218115563, "123", c);
		universidade.insereAluno(pabloHenrique);
		
		Periodo periodo = new Periodo(1);
		
		for(Periodo p : pabloHenrique.getCurso().getCurriculo().getPeriodos()) {
			if(periodo.equals(p)) {
				periodo = p;
			}
		}
		
		PeriodoCursado pc = new PeriodoCursado("2018.1");
		pabloHenrique.getHistorico().inserePeriodoCursado(pc);
		
		for(ComponenteCurricular cc : periodo.getComponentesCurricularesObrigatorios()) {
			ComponenteCurricularCursado ccc = new ComponenteCurricularCursado(cc);
			pabloHenrique.getHistorico().getPeriodosCursados().get(0).insereComponenteCurricularCursado(ccc);
		}
		
		System.out.println("Alunos da Universidade:");
		for(Aluno aluno : universidade.getAlunos()){
			System.out.println("Aluno: " + aluno.getNome());
			System.out.println("Matricula: " + aluno.getMatricula());
			aluno.getHistorico().imprimirTXT();
			System.out.println();
		}
	}
}

