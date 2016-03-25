package br.com.schimidtsolutions.design_patterns.state;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class PretoTest {
	private No no;
	private List<No> listaResposta;
	private Cor preto;

	@Before
	public void setUp() {
		preto = Cor.PRETO;
		no = new No("Teste", preto);
		listaResposta = new ArrayList<>();
	}

	@Test(expected = IllegalArgumentException.class)
	public void deveLancarExcecaoParaNoNulo() {
		preto.localizarNoMaisProfundo(null, listaResposta);
	}

	@Test(expected = IllegalArgumentException.class)
	public void deveLancarExcecaoParaListaRespostaNula() {
		preto.localizarNoMaisProfundo(no, null);
	}

	@Test
	public void nuncaDeveMudarParaOutraCorDentroDoNo() {
		preto.mudarCorDoNo(no, listaResposta);

		assertTrue(no.getCor().equals(preto));
	}

	@Test
	public void deveAdicionarNoNaListaResposta() {
		preto.localizarNoMaisProfundo(no, listaResposta);

		assertThat(listaResposta, notNullValue());
		assertThat(listaResposta.size(), is(1));
		assertThat(listaResposta.get(0).getCor(), is(Cor.PRETO));
	}
}
