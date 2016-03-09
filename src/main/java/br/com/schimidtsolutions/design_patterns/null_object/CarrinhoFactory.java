package br.com.schimidtsolutions.design_patterns.null_object;

public class CarrinhoFactory {
	private static final CarrinhoNulo NULO = new CarrinhoNulo();

	public static Carrinho of(final Item... itens) {

		if (itens == null || itens.length == 0) {
			return NULO;
		}

		return criarCarrinhoComItens(itens);
	}

	private static Carrinho criarCarrinhoComItens(final Item... itens) {
		final Carrinho carrinho = new CarrinhoComConteudo();

		for( final Item item : itens ) {
			carrinho.adicionar(item);
		}

		return carrinho;
	}
}
