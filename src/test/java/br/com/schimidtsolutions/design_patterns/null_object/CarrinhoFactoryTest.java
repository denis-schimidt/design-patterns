package br.com.schimidtsolutions.design_patterns.null_object;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import java.math.BigDecimal;

import org.junit.Test;

public class CarrinhoFactoryTest {

	@Test
	public void deveCriarCarrinhoVazioComTotalZerado() {
		final Item[] itens = {};
		final Carrinho carrinho = CarrinhoFactory.of(itens);
		assertNotNull(carrinho);
		assertThat(carrinho.getTotal(), equalTo(BigDecimal.ZERO));
	}

	@Test
	public void deveCriarCarrinhoComItensComTotalExato() {

		final Item[] itens = { new Item(1, BigDecimal.valueOf(25)), new Item(2, BigDecimal.valueOf(25)), new Item(1, BigDecimal.valueOf(5)) };

		final Carrinho carrinho = CarrinhoFactory.of(itens);
		assertNotNull(carrinho);
		assertThat(carrinho.getTotal(), equalTo(BigDecimal.valueOf(80)));
	}
}
