package br.ufba.mata62.sistemaacademico.domain;

public abstract class ImpressorHistoricoTemplate {

	public StringBuilder imprimir(Historico historico) {
		return formatar(historico);
	}

	public abstract StringBuilder formatar(Historico historico);
}
