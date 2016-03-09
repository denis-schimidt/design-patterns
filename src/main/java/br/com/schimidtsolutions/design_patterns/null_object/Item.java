package br.com.schimidtsolutions.design_patterns.null_object;

import java.math.BigDecimal;

public class Item {
	private final int quantidade;
	private final BigDecimal valor;

	public Item(final int quantidade, final BigDecimal valor) {
		this.quantidade = quantidade;
		this.valor = valor;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public BigDecimal getTotal() {
		return valor.multiply(BigDecimal.valueOf(quantidade));
	}
}
