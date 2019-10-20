package br.ufba.mata62.sistemaacademico;

public class Main {

	public static void main(String[] args) {
		Universidade ufba = new Universidade("Universidade Federal da Bahia", "UFBA");
		
		Curso CC = new Curso("Ciencia da Computa�ao");
		Curso SI = new Curso("Sistemas de Informa�ao");
		Curso LC = new Curso("Licenciatura em Computa�ao");
		
		ufba.insereCurso(CC);
		ufba.insereCurso(SI);
		ufba.insereCurso(LC);
		
		Disciplina engenhariaDeSoftwareII = new Disciplina("MATA63", "Engenharia de Software II", 68);
		
	//	CC.insereComponenteObrigatorio(new ComponenteCurricularObrigatorio(engenhariaDeSoftwareII, 6));
		//SI.insereComponenteObrigatorio(new ComponenteCurricularObrigatorio(engenhariaDeSoftwareII, 5));
		//LC.insereComponenteOptativo(new ComponenteCurricularOptativo(engenhariaDeSoftwareII));
		
		
		for(Curso curso : ufba.getCursos()) {
			System.out.println("Curso: " + curso.getNome());
			/*
			for(ComponenteCurricularObrigatorio componenteObrigatorio : curso.getComponentesObrigatorios()) {
				System.out.println("Disciplina: " + componenteObrigatorio.getDisciplina().getNome());
				System.out.println("C�digo: " + componenteObrigatorio.getDisciplina().getCodigo());
				System.out.println("Carga Hor�ria: " + componenteObrigatorio.getDisciplina().getCargaHoraria());
				System.out.println("Semestre: " + componenteObrigatorio.getSemestre());
			}
			
			for(ComponenteCurricularOptativo componenteOptativo : curso.getComponentesOptativos()) {
				System.out.println("Disciplina: " + componenteOptativo.getDisciplina().getNome());
				System.out.println("C�digo: " + componenteOptativo.getDisciplina().getCodigo());
				System.out.println("Carga Hor�ria: " + componenteOptativo.getDisciplina().getCargaHoraria());
			}
			*/
			System.out.println();
		}
	}
}
