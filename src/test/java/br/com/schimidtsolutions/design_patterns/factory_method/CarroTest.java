package br.com.schimidtsolutions.design_patterns.factory_method;

import java.util.stream.IntStream;

import org.junit.Before;
import org.junit.Test;

public class CarroTest {
	static Carro gol = new Gol();
	static Carro ferrari = new Ferrari();

	@Before
	public void init() {
		gol = new Gol();
		ferrari = new Ferrari();
	}

	@Test
	public void deveLigarCarro() {
		gol.ligarCarro();
		ferrari.ligarCarro();
	}

	@Test
	public void deveLigarFarol() {
		gol.ligarFarois();
		ferrari.ligarFarois();
	}

	@Test
	public void deveAcelerarAoMaximo() {
		final int velocidadeMaxima = 320;
		final int aceleracao = 40;
		final int totalIteracoes = velocidadeMaxima / aceleracao + 1;

		IntStream.iterate(0, v -> v + aceleracao)
			.limit(totalIteracoes)
			.forEach(v -> {
				gol.acelerarA(v);
				ferrari.acelerarA(v);
			});
	}

	@Test
	public void deveDesligarFarol() {
		gol.desligarFarois();
		ferrari.desligarFarois();
	}

	@Test
	public void deveDesligar() {
		gol.desligarCarro();
		ferrari.desligarCarro();
	}
}
