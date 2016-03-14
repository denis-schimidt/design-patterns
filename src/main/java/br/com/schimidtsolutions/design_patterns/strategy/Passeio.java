package br.com.schimidtsolutions.design_patterns.strategy;

import static br.com.schimidtsolutions.design_patterns.strategy.Valor.DIA;
import static br.com.schimidtsolutions.design_patterns.strategy.Valor.HORA;
import static br.com.schimidtsolutions.design_patterns.strategy.Valor.MES;

import java.math.BigDecimal;

public class Passeio implements VeiculoCalculavel {

	@Override
	public BigDecimal calcular(final long tempoDecorrido) {
		BigDecimal valorEstacionamento = BigDecimal.ZERO;

		if (tempoDecorrido < 12 * HORA.getValor()) {
			valorEstacionamento = BigDecimal.valueOf(2.0 * Math.ceil(tempoDecorrido / HORA.getValor()));

		} else if (tempoDecorrido > 12 * HORA.getValor() && tempoDecorrido < 15 * DIA.getValor()) {
			valorEstacionamento = BigDecimal.valueOf(26.0 * Math.ceil(tempoDecorrido / DIA.getValor()));

		} else {
			valorEstacionamento = BigDecimal.valueOf(300.0 * Math.ceil(tempoDecorrido / MES.getValor()));
		}

		return valorEstacionamento;
	}
}
