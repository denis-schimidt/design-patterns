package br.com.schimidtsolutions.design_patterns.state;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class CinzaTest {
	private No no;
	private List<No> listaResposta;
	private Cor cinza;

	@Before
	public void setUp() {
		cinza = Cor.CINZA;
		no = new No("Teste", cinza);
		listaResposta = new ArrayList<>();
	}

	@Test(expected = IllegalArgumentException.class)
	public void deveLancarExcecaoParaNoNulo() {
		cinza.localizarNoMaisProfundo(null, listaResposta);
	}

	@Test(expected = IllegalArgumentException.class)
	public void deveLancarExcecaoParaListaRespostaNula() {
		cinza.localizarNoMaisProfundo(new No("Teste"), null);
	}

	@Test
	public void nuncaDeveMudarParaOutraCorDentroDoNo() {
		cinza.mudarCorDoNo(no, listaResposta);

		assertTrue(no.getCor().equals(cinza));
	}
}
