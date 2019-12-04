package br.ufba.mata62.sistemaacademico.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import br.ufba.mata62.sistemaacademico.domain.Curriculo;
import br.ufba.mata62.sistemaacademico.domain.Universidade;
import br.ufba.mata62.sistemaacademico.repository.LeitorDados;

class ImpressorCurriculoServiceTest {
	
	ImpressorCurriculoService impressor = new ImpressorCurriculoService();

	@Test
	void testImprimir() {
		LeitorDados dados = new LeitorDados("dados.txt");
		dados.lerDados();	
		
		impressor.imprimir(Universidade.getCursos().get(112140).getCurriculo());
	}

}
