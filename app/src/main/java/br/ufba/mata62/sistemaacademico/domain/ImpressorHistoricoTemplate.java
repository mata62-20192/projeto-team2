package br.ufba.mata62.sistemaacademico.domain;


public abstract class ImpressorHistoricoTemplate {

	public abstract StringBuilder render(Historico historico);

	public void imprimir(Historico historico) {
		render(historico);
	}

}
