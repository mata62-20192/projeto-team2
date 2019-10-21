package br.ufba.mata62.sistemaacademico;

import java.io.BufferedReader;
import java.io.FileReader;

public class LeituraDeDados {

	private String nomeDoArquivo;
	
	public LeituraDeDados(String nomeDoArquivo) {
		this.nomeDoArquivo = nomeDoArquivo;
	}

	public boolean lerDados() {
		Universidade universidade = new Universidade("Universidade Federal da Bahia", "UFBA");

		try {
			FileReader arq = new FileReader("src/"+ this.nomeDoArquivo);
			BufferedReader lerArq = new BufferedReader(arq);
			String linha = "";

			int numCursos = Integer.parseInt(lerArq.readLine());

			for (int i = 0; i < numCursos; i++) {
				String nome = lerArq.readLine();
			   // System.out.println("Nome Curso: "+ nome);
				String codigo = lerArq.readLine();
				// System.out.println("Codigo curso: "+ codigo);
				int numDisciplinas = Integer.parseInt(lerArq.readLine());
				// System.out.println("Número Disciplinas: "+ numDisciplinas);

				Curso curso = new Curso(nome);
				universidade.insereCurso(curso);

				for (int j = 0; j < numDisciplinas; j++) {
					String nomeDisciplina = lerArq.readLine();
				//	System.out.println("Nome disciplina: " + nomeDisciplina);
					linha = lerArq.readLine();
					String[] split = linha.split(" ");
					String codigoDisciplina = split[0];
					int cargaHoraria = Integer.parseInt(split[3]);
					int numeroSemestre = Integer.parseInt(split[1]);
					String naturezaDisciplina = split[2];
					String curriculoDisciplina = split[4];

					Disciplina disciplina = new Disciplina(codigoDisciplina, nomeDisciplina, cargaHoraria);
					universidade.insereDisciplina(disciplina);
					Curriculo curriculo = new Curriculo(numeroSemestre);

					if (naturezaDisciplina == "OB") {
						curriculo.adicionarComponenteObrigatorio(disciplina, numeroSemestre);
					} else {
						curriculo.adicionarComponenteOptativo(disciplina);
					}

				}
			}

			arq.close();
			
			for(Curso curso : universidade.getCursos()) {
			System.out.println("Curso: " + curso.getNome());
			}
			
			Curriculo curriculo = new Curriculo(3);
			
			for(Periodo curriculos : curriculo.getPeriodos()) {
				System.out.println("OB: " + curriculos.getComponentesCurricularesObrigatorios());
			}

			return true;

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;

		}
	
	}
	
	
	
	


}
