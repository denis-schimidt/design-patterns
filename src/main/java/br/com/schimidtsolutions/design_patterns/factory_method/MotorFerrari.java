package br.com.schimidtsolutions.design_patterns.factory_method;

public class MotorFerrari implements Motor {

	@Override
	public void acelerarA(final int velocidade) {

		if (velocidade > 320) {
			System.out.printf("Impossível aumentar a velocidade (Motor Ferrari) para %d km/h.\n", velocidade);
			return;

		} else if (velocidade > 150) {
			System.out.println("Acionando turbo...");
		}

		System.out.printf("Acelerando (Motor Ferrari) a %d km/h.\n", velocidade);
	}

	@Override
	public void reduzir(final int marcha) {
		System.out.printf("Reduzindo para marcha %d.\n", marcha);
	}

	@Override
	public void desligar() {
		System.out.println("Desligando (Motor Ferrari)...");
	}

	@Override
	public void ligar() {
		System.out.println("Ligando (Motor Ferrari)...");
	}
}
