package br.com.schimidtsolutions.design_patterns.template_method;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class GeradorArquivoZipado extends GeradorArquivoComBaseEntradaPadraoDados {
	private final ZipOutputStream zipOutputStream;

	public GeradorArquivoZipado(final Path path) throws IOException {
		super(path);
		zipOutputStream = new ZipOutputStream(getFileOutputStream(), Charset.defaultCharset());
	}

	@Override
	protected void abrirArquivo() throws IOException {
		zipOutputStream.putNextEntry(new ZipEntry("texto-capturado.txt"));
	}

	@Override
	public void imprimirDados() throws IOException {
		zipOutputStream.write(obterDadosEntradaComoArrayBytes());
	}

	@Override
	public void fecharArquivo() throws IOException {

		if (zipOutputStream != null) {
			zipOutputStream.closeEntry();
			zipOutputStream.close();
		}
	}
}
