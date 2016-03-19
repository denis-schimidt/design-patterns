package br.com.schimidtsolutions.design_patterns.factory_method;

public abstract class Carro {
	private final Motor motor;

	public Carro() {
		motor = getMotor();
	}

	public abstract Motor getMotor();

	public void ligarCarro() {
		motor.ligar();
		System.out.println("Carro ligado.");
	}

	public void ligarFarois() {
		System.out.println("Faróis ligados.");
	}

	public void desligarFarois() {
		System.out.println("Faróis desligados.");
	}

	public void acelerarA(final int velocidade) {
		motor.acelerarA(velocidade);
	}

	public void frearLeve() {
		System.out.println("Freando leve...");
	}

	public void frearComReducaoMarcha(final int marcha) {
		System.out.println("Freando...");
		motor.reduzir(marcha);
	}

	public void desligarCarro() {
		motor.desligar();
		System.out.println("Carro desligado.");
	}
}
