package br.com.schimidtsolutions.design_patterns.bridge;

import java.util.zip.ZipOutputStream;

public interface ProcessadorDadosCompactados extends ProcessadorDados {

	public ZipOutputStream getZipOutputStream();
}
