package br.com.schimidtsolutions.design_patterns.factory_method;

public class Gol extends Carro {

	@Override
	public Motor getMotor() {
		return new MotorWolkswagen();
	}
}
