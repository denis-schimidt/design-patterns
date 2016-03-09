package br.com.schimidtsolutions.design_patterns.null_object;

import java.math.BigDecimal;

public interface Carrinho {

	public BigDecimal getTotal();

	void adicionar(Item item);
}
