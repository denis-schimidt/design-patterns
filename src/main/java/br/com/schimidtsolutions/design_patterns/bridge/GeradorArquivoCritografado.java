package br.com.schimidtsolutions.design_patterns.bridge;

import java.io.IOException;
import java.nio.file.Path;

public class GeradorArquivoCritografado extends GeradorArquivoComBaseEntradaPadraoDados {

	public GeradorArquivoCritografado(final Path pathArquivo, final ProcessadorDados processadorDados) throws IOException {
		super(pathArquivo, processadorDados);
	}

	@Override
	void abrirArquivo() throws IOException {}

	@Override
	void imprimirDados() throws IOException {
		final byte[] dadosEntrada = getProcessadorDados().processar(obterDadosEntradaComoArrayBytes());
		getFileOutputStream().write(dadosEntrada);
	}

	@Override
	void fecharArquivo() throws IOException {
		getArquivo().setReadOnly();
	}
}
