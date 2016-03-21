package br.com.schimidtsolutions.design_patterns.bridge;

import java.io.IOException;
import java.util.zip.ZipOutputStream;

public class ProcessadorDadosNulo implements ProcessadorDadosCompactados {

	@Override
	public byte[] processar(final byte[] arquivo) throws IOException {
		return arquivo;
	}

	@Override
	public ZipOutputStream getZipOutputStream() {
		return null;
	}
}
