package br.ufba.mata62.sistemaacademico.domain;

public enum Natureza {
	OPTATIVA("OP"),
	OBRIGATORIA("OB");
	
	private String sigla;

	private Natureza(String sigla) {
		this.sigla = sigla;
	}

	public String getSigla() {
		return sigla;
	}
	
	
	
}
