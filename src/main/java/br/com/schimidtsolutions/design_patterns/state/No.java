package br.com.schimidtsolutions.design_patterns.state;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.google.common.annotations.VisibleForTesting;

public class No {
	private final Set<No> nosFilhos = new HashSet<>();
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
		cor.mudarCorDoNo(this, listaResposta);
	}

	void setCor(final Cor cor, final List<No> nos) {
		this.cor = cor;
		cor.localizarNoMaisProfundo(this, nos);
	}

	Cor getCor() {
		return cor;
	}

	public String getNome() {
		return nome;
	}

	public Set<No> getNosFilhos() {
		return nosFilhos;
	}

	public void addNoFilho(final No no) {
		nosFilhos.add(no);
	}

	@Override
	public String toString() {
		return String.format("No [nosFilhos=%s, cor=%s, nome=%s]", nosFilhos, cor, nome);
	}
}
