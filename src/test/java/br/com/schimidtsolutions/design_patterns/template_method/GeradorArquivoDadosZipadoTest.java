package br.com.schimidtsolutions.design_patterns.template_method;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.io.File;
import java.nio.file.Paths;

import org.junit.Test;

public class GeradorArquivoDadosZipadoTest {

	@Test
	public void deveGerarArquivoZipado() throws Exception {
		final GeradorArquivoComBaseEntradaPadraoDados geradorArquivo = new GeradorArquivoZipado(Paths.get("test.zip"));
		final File arquivo = geradorArquivo.gerarArquivo();

		assertThat(arquivo.exists(), is(true));
		assertThat(arquivo.isFile(), is(true));
		assertThat(arquivo.getName(), is("test.zip"));
	}
}
