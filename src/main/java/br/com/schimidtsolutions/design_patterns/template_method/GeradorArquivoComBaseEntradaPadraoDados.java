package br.com.schimidtsolutions.design_patterns.template_method;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

public abstract class GeradorArquivoComBaseEntradaPadraoDados {
	private List<String> dadosEntrada;
	private FileOutputStream fileOutputStream;
	private File arquivo;

	GeradorArquivoComBaseEntradaPadraoDados(final Path path) throws IOException {
		criarArquivo(path);
	}

	public File gerarArquivo() throws Exception {
		obterDadosExternos();

		if (!dadosEntrada.isEmpty()) {

			try {
				abrirArquivo();
				imprimirDados();

			} finally {
				fecharArquivo();
			}
		}

		return arquivo;
	}

	private void obterDadosExternos() throws IOException {
		System.out.println("Insira dados para o arquivo e para terminar digite Enter + CTRL + Z...");

		try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
			dadosEntrada = reader.lines().collect(Collectors.toList());
		}
	}

	private void criarArquivo(final Path path) throws FileNotFoundException {
		arquivo = path.toFile();

		if (arquivo.exists()) {
			arquivo.delete();
			arquivo = new File(path.toUri());
		}

		fileOutputStream = new FileOutputStream(arquivo);
	}

	byte[] obterDadosEntradaComoArrayBytes() {
		return getDadosEntrada().stream()
				.collect(Collectors.joining(System.lineSeparator()))
				.getBytes(Charset.defaultCharset());
	}

	File getArquivo() {
		return arquivo;
	}

	FileOutputStream getFileOutputStream() {
		return fileOutputStream;
	}

	List<String> getDadosEntrada() {
		return dadosEntrada;
	}

	abstract void abrirArquivo() throws IOException;

	abstract void imprimirDados() throws Exception;

	abstract void fecharArquivo() throws IOException;
}
