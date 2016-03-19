package br.com.schimidtsolutions.design_patterns.factory_method;

public interface Motor {

	void ligar();

	void acelerarA(final int velocidade);

	void reduzir(int marcha);

	void desligar();
}
