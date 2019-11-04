package br.ufba.mata62.sistemaacademico;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class LeitorDados {

	private String nomeDoArquivo;
	private Universidade universidade;
	
	public LeitorDados(String nomeDoArquivo, Universidade universidade) {
		this.nomeDoArquivo = nomeDoArquivo;
		this.universidade = universidade;
	}

	public boolean lerDados() {

		try {
			FileReader arq = new FileReader("src/"+ this.nomeDoArquivo);
			// BufferedReader lerArq = new BufferedReader(arq);
			
			BufferedReader lerArq = new BufferedReader(new InputStreamReader(new FileInputStream("src/"+ nomeDoArquivo), "UTF-8"));
			
			String linha = "";

			int numCursos = Integer.parseInt(lerArq.readLine());

			for (int i = 0; i < numCursos; i++) {
				String nomeCurso = lerArq.readLine();
				String codigoCurso = lerArq.readLine();
				int numDisciplinas = Integer.parseInt(lerArq.readLine());

				Curriculo curriculo = new Curriculo();

				for (int j = 0; j < numDisciplinas; j++) {
					String nomeDisciplina = lerArq.readLine();
					
					linha = lerArq.readLine();
					String[] split = linha.split(" ");
					
					String codigoDisciplina = split[0];
					int cargaHoraria = Integer.parseInt(split[3]);
					int numeroSemestre = Integer.parseInt(split[1]);
					String naturezaDisciplina = split[2];
					String codigoCurriculo = split[4];

					Disciplina disciplina = new Disciplina(codigoDisciplina, nomeDisciplina, cargaHoraria);
					universidade.insereDisciplina(codigoDisciplina, disciplina);

					if (naturezaDisciplina.equals("OB")) {
						curriculo.adicionarComponenteObrigatorio(disciplina, numeroSemestre);
					} else {
						curriculo.adicionarComponenteOptativo(disciplina);
					}
				}

				Curso curso = new Curso(nomeCurso, curriculo);
				universidade.insereCurso(curso);
			}

			arq.close();

			return true;

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
}
