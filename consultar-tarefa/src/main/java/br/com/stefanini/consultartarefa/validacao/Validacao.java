package br.com.stefanini.consultartarefa.validacao;

import br.com.stefanini.consultartarefa.exception.ValidacaoException;

public abstract class Validacao {

	public void lancarValidacaoException(boolean condicao, String mensagem) {
		if(condicao) {
			throw new ValidacaoException(mensagem);
		}
	}
}
