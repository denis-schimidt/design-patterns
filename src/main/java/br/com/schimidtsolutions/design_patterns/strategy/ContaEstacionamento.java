package br.com.schimidtsolutions.design_patterns.strategy;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDateTime;

import com.google.common.base.Preconditions;

public final class ContaEstacionamento {
	private final Duration tempoDecorrido;
	private VeiculoCalculavel veiculo;

	public ContaEstacionamento(final LocalDateTime inicio, final LocalDateTime fim, final VeiculoCalculavel veiculo) {
		validarDatas(inicio, fim, veiculo);

		tempoDecorrido = Duration.between(inicio, fim);
		setVeiculo(veiculo);
	}

	private void validarDatas(final LocalDateTime inicio, final LocalDateTime fim, final VeiculoCalculavel veiculo) {
		Preconditions.checkArgument(inicio != null, "O início não pode ser nulo.");
		Preconditions.checkArgument(fim != null, "O fim não pode ser nulo.");
		Preconditions.checkArgument(inicio.isBefore(fim), "O início não pode ser superior ao fim.");
	}

	public void setVeiculo(final VeiculoCalculavel veiculo) {
		Preconditions.checkArgument(veiculo != null, "O veículo não pode ser nulo.");

		this.veiculo = veiculo;
	}

	public ContaEstacionamento(final LocalDateTime inicio, final VeiculoCalculavel veiculo) {
		this(inicio, LocalDateTime.now(), veiculo);
	}

	public BigDecimal fecharConta() {
		return veiculo.calcular(tempoDecorrido.toHours());
	}
}
