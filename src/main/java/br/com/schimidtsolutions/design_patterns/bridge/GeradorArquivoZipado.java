package br.com.schimidtsolutions.design_patterns.bridge;

import java.io.IOException;
import java.nio.file.Path;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class GeradorArquivoZipado extends GeradorArquivoComBaseEntradaPadraoDados {
	private ZipOutputStream zipOutputStream;

	public GeradorArquivoZipado(final Path pathArquivo) throws IOException {
		super(pathArquivo);
		setProcessadorDados(new CompactadorArquivo(getFileOutputStream()));
	}

	@Override
	void ajustarConfiguracoesExtrasProcessadorDados() {
		final ProcessadorDados processador = getProcessadorDados();

		if (processador instanceof ProcessadorDadosCompactados) {
			zipOutputStream = ((ProcessadorDadosCompactados) processador).getZipOutputStream();

		} else {
			throw new IllegalArgumentException("Não foi possível obter o zipOutputStream proveniente do processador dados compactados.");
		}
	}

	@Override
	protected void abrirArquivo() throws IOException {
		zipOutputStream.putNextEntry(new ZipEntry("texto-capturado.txt"));
	}

	@Override
	public void imprimirDados() throws IOException {
		getProcessadorDados().processar(obterDadosEntradaComoArrayBytes());
	}

	@Override
	public void fecharArquivo() throws IOException {

		if (zipOutputStream != null) {
			zipOutputStream.closeEntry();
			zipOutputStream.close();
		}
	}
}
