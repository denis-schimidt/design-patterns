package br.com.schimidtsolutions.design_patterns.bridge;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.Test;

public class GeradorArquivoDadosZipadoBridgeTest {

	@Test
	public void deveGerarArquivoZipado() throws Exception {
		final Path pathArquivo = Paths.get("test.zip");

		final GeradorArquivoComBaseEntradaPadraoDados geradorArquivo = new GeradorArquivoZipado(pathArquivo);
		final File arquivo = geradorArquivo.gerarArquivo();

		assertThat(arquivo.exists(), is(true));
		assertThat(arquivo.isFile(), is(true));
		assertThat(arquivo.getName(), is(pathArquivo.getFileName().toFile().getName()));
	}
}
