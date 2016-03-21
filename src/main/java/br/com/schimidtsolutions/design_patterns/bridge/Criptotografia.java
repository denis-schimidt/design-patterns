package br.com.schimidtsolutions.design_patterns.bridge;

import static com.google.common.base.Preconditions.checkArgument;

import java.security.MessageDigest;

public class Criptotografia implements ProcessadorDados {
	private final MessageDigest messageDigest;

	public Criptotografia() throws Exception {
		this(MessageDigest.getInstance("SHA-256"));
	}

	public Criptotografia(final MessageDigest messageDigest) {
		checkArgument(messageDigest != null, "O messageDigest não pode ser nulo.");

		this.messageDigest = messageDigest;
	}

	@Override
	public byte[] processar(final byte[] arquivo) {
		messageDigest.update(arquivo);
		return messageDigest.digest();
	}
}
