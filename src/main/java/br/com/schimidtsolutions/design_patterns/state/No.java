package br.com.schimidtsolutions.design_patterns.state;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import com.google.common.annotations.VisibleForTesting;

public class No {
	private final Set<No> nosFilhos = new LinkedHashSet<>();
	private Cor cor;
	private final String nome;

	public No(final String nome) {
		cor = Cor.BRANCO;
		this.nome = nome;
	}

	@VisibleForTesting
	No(final String nome, final Cor cor) {
		this.cor = cor;
		this.nome = nome;
	}

	public void localizarNoMaisProfundo(final List<No> listaResposta) {
		cor.mudarCorNoAtual(this, listaResposta);
	}

	void setCor(final Cor cor, final List<No> nos) {
		this.cor = cor;
		cor.aprofundarBuscaNosFilhos(this, nos);
	}

	public Cor getCor() {
		return cor;
	}

	public String getNome() {
		return nome;
	}

	public Set<No> getNosFilhos() {
		return Collections.unmodifiableSet(nosFilhos);
	}

	public void addNoFilho(final No no) {
		nosFilhos.add(no);
	}

	@Override
	public String toString() {
		final int maxLen = 50;
		return String.format("No [nome=%s, cor=%s, nosFilhos=%s]", nome, cor, nosFilhos != null ? toString(nosFilhos, maxLen) : null);
	}

	private String toString(final Collection<No> collection, final int maxLen) {
		final StringBuilder builder = new StringBuilder();
		builder.append("[");
		int i = 0;
		for (final Iterator<No> iterator = collection.iterator(); iterator.hasNext() && i < maxLen; i++) {
			if (i > 0) {
				builder.append(", ");
			}
			builder.append(iterator.next().getNome());
		}
		builder.append("]");
		return builder.toString();
	}
}
