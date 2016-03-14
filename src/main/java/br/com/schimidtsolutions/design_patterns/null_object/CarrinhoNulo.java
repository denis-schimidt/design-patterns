package br.com.schimidtsolutions.design_patterns.null_object;

import java.math.BigDecimal;

public class CarrinhoNulo implements Carrinho {

	@Override
	public BigDecimal getTotal() {
		return BigDecimal.ZERO;
	}

	@Override
	public void adicionar(final Item item) {
		throw new UnsupportedOperationException();
	}
}
