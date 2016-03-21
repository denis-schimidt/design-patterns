package br.com.schimidtsolutions.design_patterns.bridge;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.io.File;
import java.nio.file.Paths;

import org.junit.Test;

public class GeradorArquivoDadosCriptografadosBridgeTest {

	@Test
	public void deveGerarArquivoCriptografado() throws Exception {
		final GeradorArquivoComBaseEntradaPadraoDados geradorArquivo = new GeradorArquivoCritografado(Paths.get("test1.txt"), new Criptotografia());
		final File arquivo = geradorArquivo.gerarArquivo();

		assertThat(arquivo.exists(), is(true));
		assertThat(arquivo.isFile(), is(true));
		assertThat(arquivo.canWrite(), is(false));
		assertThat(arquivo.getName(), is("test1.txt"));
	}
}
