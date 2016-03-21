package br.com.schimidtsolutions.design_patterns.bridge;

import java.io.IOException;

public class ProcessadorDadosNulo implements ProcessadorDados {

	@Override
	public byte[] processar(final byte[] arquivo) throws IOException {
		return arquivo;
	}
}
