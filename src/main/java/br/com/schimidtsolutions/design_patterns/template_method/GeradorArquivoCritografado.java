package br.com.schimidtsolutions.design_patterns.template_method;

import java.io.IOException;
import java.nio.file.Path;
import java.security.MessageDigest;

public class GeradorArquivoCritografado extends GeradorArquivoComBaseEntradaPadraoDados {
	private final MessageDigest digest;

	public GeradorArquivoCritografado(final Path path) throws Exception {
		this(path, MessageDigest.getInstance("SHA-256"));
	}

	public GeradorArquivoCritografado(final Path path, final MessageDigest digest) throws Exception {
		super(path);
		this.digest = digest;
	}

	@Override
	void abrirArquivo() throws IOException {}

	@Override
	void imprimirDados() throws Exception {
		digest.update(obterDadosEntradaComoArrayBytes());
		getFileOutputStream().write(digest.digest());
	}

	@Override
	void fecharArquivo() throws IOException {
		getArquivo().setReadOnly();
	}
}
