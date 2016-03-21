package br.com.schimidtsolutions.design_patterns.bridge;

import static com.google.common.base.Preconditions.checkArgument;

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
	private ProcessadorDados processadorDados;

	GeradorArquivoComBaseEntradaPadraoDados(final Path path, final ProcessadorDados posProcessador) throws IOException {
		checkArgument(path != null, "O path não pode ser nulo.");
		criarArquivo(path);
		setProcessadorDados(posProcessador);
	}

	public GeradorArquivoComBaseEntradaPadraoDados(final Path path) throws IOException {
		this(path, new ProcessadorDadosNulo());
	}

	public void setProcessadorDados(final ProcessadorDados processadorDados) {
		checkArgument(processadorDados != null, "O processadorDados não pode ser nulo.");
		this.processadorDados = processadorDados;

		if (!processadorDados.getClass().equals(ProcessadorDadosNulo.class)) {
			ajustarConfiguracoesExtrasProcessadorDados();
		}
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

	ProcessadorDados getProcessadorDados() {
		return processadorDados;
	}

	void ajustarConfiguracoesExtrasProcessadorDados() {}

	abstract void abrirArquivo() throws IOException;

	abstract void imprimirDados() throws Exception;

	abstract void fecharArquivo() throws IOException;
}
