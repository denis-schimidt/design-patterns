package br.com.schimidtsolutions.design_patterns.strategy;

enum Valor {
	HORA(2), DIA(25), MES(250);

	private int valor;

	private Valor(final int valor) {
		this.valor = valor;
	}

	public int getValor() {
		return valor;
	}
}
