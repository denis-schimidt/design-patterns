package br.com.schimidtsolutions.design_patterns.state;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.junit.Test;

import com.google.common.collect.Sets;

public class NoTest {

	@Test
	public void deveAdicionarNoAdjacente() {
		final No raiz = new No("Raiz");
		final No folha = new No("Folha");

		raiz.addNoFilho(folha);

		assertThat(raiz.getNosFilhos().size(), is(1));
	}

	@Test
	public void deveFazerBuscaCompletaMudandoAsCoresDeTodosOsNos() {
		final No no = new No("Teste");
		final List<No> listaResposta = new ArrayList<>();

		Sets.newHashSet(new No("primeiro filho"), new No("segundo filho"), new No("terceiro filho")).forEach(no::addNoFilho);

		no.localizarNoMaisProfundo(listaResposta);

		no.getNosFilhos().forEach(noFilho -> assertThat(noFilho.getCor(), is(Cor.PRETO)));
		assertThat(no.getCor(), is(Cor.PRETO));
	}

	@Test
	public void deveFazerBuscaCompletaNaOrdemCorreta() {
		final List<No> listaResposta = new ArrayList<>();

		final No a = new No("A"); final No b = new No("B");
		final No c = new No("C"); final No d = new No("D");
		final No e = new No("E"); final No f = new No("F");
		final No g = new No("G"); final No h = new No("H");

		a.addNoFilho(b);
		a.addNoFilho(c);
		b.addNoFilho(d);
		b.addNoFilho(e);
		c.addNoFilho(f);
		c.addNoFilho(g);
		c.addNoFilho(h);

		a.localizarNoMaisProfundo(listaResposta);

		final Iterator<String> noIterator = Arrays.asList("F", "H", "G", "C", "E", "D", "B", "A").iterator();

		listaResposta.forEach(no -> {
			assertThat(no.getNome(), is(noIterator.next()));
			assertThat(no.getCor(), is(Cor.PRETO));
		});
	}
}
