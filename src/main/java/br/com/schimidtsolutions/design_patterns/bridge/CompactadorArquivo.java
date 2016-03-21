package br.com.schimidtsolutions.design_patterns.bridge;

import static com.google.common.base.Preconditions.checkArgument;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipOutputStream;

public class CompactadorArquivo implements ProcessadorDadosCompactados {
	private final ZipOutputStream zipOutputStream;

	public CompactadorArquivo(final FileOutputStream fileOutputStream) {
		checkArgument(fileOutputStream != null, "O fileOutputStream não pode ser nulo.");
		zipOutputStream = new ZipOutputStream(fileOutputStream);
	}

	@Override
	public byte[] processar(final byte[] dadosEntrada) throws IOException {
		zipOutputStream.write(dadosEntrada);

		return dadosEntrada;
	}

	@Override
	public ZipOutputStream getZipOutputStream() {
		return zipOutputStream;
	}
}
