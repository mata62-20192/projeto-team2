package br.ufba.mata62.sistemaacademico;

public class Main {

	public static void main(String[] args) {
		Universidade ufba = new Universidade("Universidade Federal da Bahia", "UFBA");
		
		Curso CC = new Curso("Ciência da Computação");
		Curso SI = new Curso("Sistemas de Informação");
		Curso LC = new Curso("Licenciatura em Computação");
		
		ufba.insereCurso(CC);
		ufba.insereCurso(SI);
		ufba.insereCurso(LC);
		
		Disciplina engenhariaDeSoftware = new Disciplina("MATA63", "Engenharia de Software", 68);
		
		CC.insereComponenteObrigatorio(new ComponenteCurricularObrigatorio(engenhariaDeSoftware, 6));
		SI.insereComponenteObrigatorio(new ComponenteCurricularObrigatorio(engenhariaDeSoftware, 5));
		LC.insereComponenteOptativo(new ComponenteCurricularOptativo(engenhariaDeSoftware));
		
		
		for(Curso curso : ufba.getCursos()) {
			System.out.println("Curso: " + curso.getNome());
			
			for(ComponenteCurricularObrigatorio componenteObrigatorio : curso.getComponentesObrigatorios()) {
				System.out.println("Disciplina: " + componenteObrigatorio.getDisciplina().getNome());
				System.out.println("Código: " + componenteObrigatorio.getDisciplina().getCodigo());
				System.out.println("Carga Horária: " + componenteObrigatorio.getDisciplina().getCargaHoraria());
				System.out.println("Semestre: " + componenteObrigatorio.getSemestre());
			}
			
			for(ComponenteCurricularOptativo componenteOptativo : curso.getComponentesOptativos()) {
				System.out.println("Disciplina: " + componenteOptativo.getDisciplina().getNome());
				System.out.println("Código: " + componenteOptativo.getDisciplina().getCodigo());
				System.out.println("Carga Horária: " + componenteOptativo.getDisciplina().getCargaHoraria());
			}
			
			System.out.println();
		}
	}
}
