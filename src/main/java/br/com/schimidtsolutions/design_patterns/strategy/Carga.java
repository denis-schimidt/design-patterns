package br.com.schimidtsolutions.design_patterns.strategy;

import static br.com.schimidtsolutions.design_patterns.strategy.Valor.HORA;

import java.math.BigDecimal;

public class Carga implements VeiculoCalculavel {
	private final int eixos;
	private final double pesoCarga;

	public Carga(final int eixos, final double pesoCarga) {
		this.eixos = eixos;
		this.pesoCarga = pesoCarga;
	}

	@Override
	public BigDecimal calcular(final long tempoDecorrido) {
		BigDecimal valorEstacionamento = BigDecimal.ZERO;

		if (pesoCarga > 1000) {
			valorEstacionamento = BigDecimal.valueOf(eixos * tempoDecorrido * HORA.getValor());

		} else {
			valorEstacionamento = BigDecimal.valueOf(tempoDecorrido * pesoCarga);
		}

		return valorEstacionamento;
	}
}
