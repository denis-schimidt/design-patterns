package br.com.schimidtsolutions.design_patterns.state;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class BrancoTest {

	@Mock
	private List<No> listaResposta;

	private final Cor branco = Cor.BRANCO;

	@Test(expected = IllegalArgumentException.class)
	public void deveLancarExcecaoParaNoNulo() {
		branco.mudarCorDoNo(null, listaResposta);
	}

	@Test(expected = IllegalArgumentException.class)
	public void deveLancarExcecaoParaListaRespostaNula() {
		branco.mudarCorDoNo(new No("Teste"), null);
	}

	@Test
	public void deveMudarParaCinzaACorDentroDoNo() {
		final No no = new No("Teste");
		branco.mudarCorDoNo(no, listaResposta);

		assertTrue(no.getCor() == Cor.PRETO);
	}

	@Test
	public void naoDeveFazerLocalizacaoEmProfundidade() {
		final No no = mock(No.class);
		branco.localizarNoMaisProfundo(no, listaResposta);

		verify(no, never()).localizarNoMaisProfundo(listaResposta);
	}
}
