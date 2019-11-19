package br.ufba.mata62.sistemaacademico.domain;

public abstract class ImpressorHistoricoTemplate {

	public StringBuilder imprimir(Historico historico) {
		return new StringBuilder(imprimirHTML(historico).toString() + imprimirTXT(historico).toString());
	}

	public abstract StringBuilder imprimirTXT(Historico historico);
	public abstract StringBuilder imprimirHTML(Historico historico);
}
