package br.ufba.mata62.sistemaacademico.domain;

import br.ufba.mata62.sistemaacademico.service.HistoricoService;

public abstract class ImpressaoHistoricoTemplate {

	public abstract void render(Historico historico);

	public void imprime(Historico historico) {
		render(historico);
	}

}
