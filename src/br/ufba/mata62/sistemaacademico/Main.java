package br.ufba.mata62.sistemaacademico;

public class Main {
	
	public static void main(String[] args){
		
		Universidade universidade = new Universidade("Universidade Federal da Bahia", "UFBA");
		
		LeituraDeDados leitor = new LeituraDeDados("dados.txt", universidade);
		leitor.lerDados();
		
		System.out.println("Cursos da Universidade:");
		for(Curso curso : universidade.getCursos()) {
			System.out.println("Curso: " + curso.getNome());
			curso.getCurriculo().imprimir();
			System.out.println();
		}
		
		System.out.println("Alunos da Universidade:");
		for(Aluno aluno : universidade.getAlunos()){
			System.out.println("Aluno: " + aluno.getNome());
			System.out.println("Matrícula: " + aluno.getMatricula());
			aluno.getHistorico().imprimirTXT();
			System.out.println();
		}
		
		System.out.println("Disciplinas da Universidade:");
		for(Disciplina disciplina : universidade.getDisciplinas()) {
			System.out.println("Disciplina: " + disciplina.getNome());
			System.out.println("Código: " + disciplina.getCodigo());
			System.out.println("Carga Horária: " + disciplina.getCargaHoraria());
			System.out.println();
		}
	}
}

