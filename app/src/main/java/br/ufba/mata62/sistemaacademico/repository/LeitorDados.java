package br.ufba.mata62.sistemaacademico.repository;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

import br.ufba.mata62.sistemaacademico.domain.Curriculo;
import br.ufba.mata62.sistemaacademico.domain.Curso;
import br.ufba.mata62.sistemaacademico.domain.Disciplina;
import br.ufba.mata62.sistemaacademico.domain.Universidade;

public class LeitorDados {

	private String nomeDoArquivo;
	
	public LeitorDados(String nomeDoArquivo) {
		this.nomeDoArquivo = nomeDoArquivo;
	}

	public void lerDados(){

		try {

			BufferedReader lerArq = new BufferedReader(new InputStreamReader(new FileInputStream("src/main/assets/"+ this.nomeDoArquivo), "UTF-8"));

			String linha = "";

			int numCursos = Integer.parseInt(lerArq.readLine());

			for (int i = 0; i < numCursos; i++) {
				String nomeCurso = lerArq.readLine();
				Integer codigoCurso = Integer.parseInt(lerArq.readLine());
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
					Universidade.insereDisciplina(codigoDisciplina, disciplina);

					if (naturezaDisciplina.equals("OB")) {
						curriculo.adicionarComponenteObrigatorio(disciplina, numeroSemestre);
					} else {
						curriculo.adicionarComponenteOptativo(disciplina);
					}
				}

				Curso curso = new Curso(nomeCurso, codigoCurso, curriculo);
				Universidade.insereCurso(codigoCurso, curso);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
