package br.com.schimidtsolutions.design_patterns.factory_method;

public class Ferrari extends Carro {

	@Override
	public Motor getMotor() {
		return new MotorFerrari();
	}
}
