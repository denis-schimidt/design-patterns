package br.com.schimidtsolutions.design_patterns.factory_method;

public class MotorWolkswagen implements Motor {

	@Override
	public void acelerarA(final int velocidade) {

		if (velocidade > 190) {
			System.out.printf("Impossível aumentar a velocidade (Motor Wolkswagen) para %d km/h.\n", velocidade);
		} else {
			System.out.printf("Acelerando (Motor Wolkswagen) a %d km/h.\n", velocidade);
		}
	}

	@Override
	public void reduzir(final int marcha) {
		System.out.printf("Reduzindo para marcha %d.\n", marcha);
	}

	@Override
	public void desligar() {
		System.out.println("Desligando (Motor Wolkswagen)...");
	}

	@Override
	public void ligar() {
		System.out.println("Ligando (Motor Wolkswagen)...");
	}
}
