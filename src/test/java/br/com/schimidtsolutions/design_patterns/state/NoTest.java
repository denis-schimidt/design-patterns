package br.com.schimidtsolutions.design_patterns.state;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.junit.Test;

public class NoTest {

	@Test
	public void deveAdicionarNoFilho() {
		final No raiz = new No("Raiz");
		final No folha = new No("Folha");

		raiz.addNoFilho(folha);

		assertThat(raiz.getNosFilhos().size(), is(1));
	}

	@Test
	public void deveTrazerNosNaOrdemECoresCorretas() {
		final List<No> listaResposta = new ArrayList<>();

		final No a = new No("A");
		final No b = new No("B");
		final No c = new No("C");
		final No d = new No("D");
		final No e = new No("E");
		final No f = new No("F");
		final No g = new No("G");
		final No h = new No("H");

		a.addNoFilho(b);
		b.addNoFilho(c);
		c.addNoFilho(d);
		d.addNoFilho(b);
		a.addNoFilho(e);
		e.addNoFilho(f);
		f.addNoFilho(c);
		f.addNoFilho(g);
		f.addNoFilho(h);
		a.addNoFilho(h);

		a.localizarNoMaisProfundo(listaResposta);

		final Iterator<String> noIterator = Arrays.asList("D", "C", "B", "G", "H", "F", "E", "A").iterator();

		listaResposta.forEach(no -> {
			assertThat(no.getNome(), is(noIterator.next()));
			assertThat(no.getCor(), is(Cor.PRETO));
		});
	}
}
