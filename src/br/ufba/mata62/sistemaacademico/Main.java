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
		for(Disciplina disciplina : universidade.getDisciplinas().values()) {
			System.out.println("Disciplina: " + disciplina.getNome());
			System.out.println("Codigo: " + disciplina.getCodigo());
			System.out.println("Carga Horaria: " + disciplina.getCargaHoraria());
			System.out.println();
		} 
		
		
		String cienciaDaComputacao = "CiENCIA DA COMPUTAÇAO - BACHARELADO  - SALVADOR";
		
		Curso c = null;
		
		Collator collator = Collator.getInstance (new Locale ("pt", "BR"));
		collator.setStrength(Collator.PRIMARY);
		
		for(Curso curso : universidade.getCursos()) {
			if(collator.compare(cienciaDaComputacao, curso.getNome()) == 0) {
				c = curso;
			}
		}
		
		Aluno pabloHenrique = new Aluno("Pablo Henrique Rego dos Santos Cabral", 218115563, "123", c);
		universidade.insereAluno(218115563, pabloHenrique);
		
		PeriodoCursado pc = new PeriodoCursado("2018.1");
		pabloHenrique.getHistorico().inserePeriodoCursado(pc);
		
		for(ComponenteCurricular cc : pabloHenrique.getComponentesCurricularesObrigatorios(1)) {
			ComponenteCurricularCursado ccc = new ComponenteCurricularCursado(cc);
			pabloHenrique.insereComponenteCurricularCursado(1, ccc);;
			ccc.setConceito(Conceito.APROVADO);
			ccc.setNota(5.0);
		}
		
		System.out.println("Alunos da Universidade:");
		for(Aluno aluno : universidade.getAlunos().values()){
			System.out.println("Aluno: " + aluno.getNome());
			System.out.println("Matricula: " + aluno.getMatricula());
			aluno.getHistorico().imprimirTXT();
			aluno.getHistorico().imprimirHTML();
			System.out.println();
		}
	}
}
