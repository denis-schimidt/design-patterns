package br.com.schimidtsolutions.design_patterns.strategy;

import java.math.BigDecimal;

public interface VeiculoCalculavel {
	BigDecimal calcular(long tempoDecorrido);
}
