package br.com.schimidtsolutions.design_patterns;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.closeTo;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.junit.Test;

import br.com.schimidtsolutions.design_patterns.strategy.ContaEstacionamento;
import br.com.schimidtsolutions.design_patterns.strategy.Passeio;

public class ContaEstacionamentoTest {

	@Test
	public void deveFecharContaVeiculoPasseio() {
		final ContaEstacionamento contaEstacionamento = new ContaEstacionamento(LocalDateTime.now().minusHours(5), new Passeio());

		assertThat(contaEstacionamento.fecharConta(), is(closeTo(BigDecimal.valueOf(4), BigDecimal.ZERO)));
	}

	@Test
	public void deveLancarExcecaoVeiculoNulo() {

		try {
			new ContaEstacionamento(LocalDateTime.now().minusHours(5), null);
			fail();

		} catch (final IllegalArgumentException e) {
			assertThat(e.getMessage(), equalTo("O veículo não pode ser nulo."));
		}
	}

	@Test
	public void deveLancarExcecaoDataInicialNula() {

		try {
			new ContaEstacionamento(null, new Passeio());
			fail();

		} catch (final IllegalArgumentException e) {
			assertThat(e.getMessage(), equalTo("O início não pode ser nulo."));
		}
	}

	@Test
	public void deveLancarExcecaoDataFimNulo() {

		try {
			new ContaEstacionamento(LocalDateTime.now(), null, new Passeio());
			fail();

		} catch (final IllegalArgumentException e) {
			assertThat(e.getMessage(), equalTo("O fim não pode ser nulo."));
		}
	}

	@Test
	public void deveLancarExcecaoDataInicioMaiorQueFinal() {

		try {
			new ContaEstacionamento(LocalDateTime.now().plusSeconds(5), LocalDateTime.now(), new Passeio());
			fail();

		} catch (final IllegalArgumentException e) {
			assertThat(e.getMessage(), equalTo("O início não pode ser superior ao fim."));
		}
	}
}
