package br.com.schimidtsolutions.design_patterns.null_object;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class CarrinhoComConteudo implements Carrinho{
	private List<Item> itens = new ArrayList<>();
	
	@Override
	public void adicionar(Item item) {
		itens.add(item);
	}

	@Override
	public BigDecimal getTotal() {
		return itens.stream()
			.map(i-> i.getTotal())
			.reduce(BigDecimal.ZERO, BigDecimal::add);
	}
}
