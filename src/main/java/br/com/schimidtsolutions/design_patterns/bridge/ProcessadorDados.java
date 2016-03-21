package br.com.schimidtsolutions.design_patterns.bridge;

import java.io.IOException;

public interface ProcessadorDados {

	byte[] processar(byte[] arquivo) throws IOException;
}
