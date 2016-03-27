package br.com.schimidtsolutions.design_patterns.state;

import java.util.List;

import com.google.common.base.Preconditions;

public enum Cor {

	BRANCO {

		@Override
		public void mudarCorNoAtual(final No no, final List<No> listaResposta) {
			validarDadosEntrada(no, listaResposta);

			no.setCor(Cor.CINZA, listaResposta);
		}
	},

	CINZA {

		@Override
		void aprofundarBuscaNosFilhos(final No no, final List<No> listaResposta) {
			validarDadosEntrada(no, listaResposta);

			no.getNosFilhos().forEach(noFilho -> noFilho.localizarNoMaisProfundo(listaResposta));

			no.setCor(PRETO, listaResposta);
		}
	},

	PRETO{

		@Override
		void aprofundarBuscaNosFilhos(final No no, final List<No> listaResposta) {
			validarDadosEntrada(no, listaResposta);

			listaResposta.add(no);
		}
	};

	void mudarCorNoAtual(final No no, final List<No> listaResposta) {}

	void aprofundarBuscaNosFilhos(final No no, final List<No> listaResposta) {}

	private static void validarDadosEntrada(final No no, final List<No> listaResposta) {
		Preconditions.checkArgument(no != null, "O no não pode ser nulo.");
		Preconditions.checkArgument(listaResposta != null, "A listaResposta não pode ser nula.");
	}
}
