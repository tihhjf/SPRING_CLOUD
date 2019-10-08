package br.com.stefanini.tarefa.validacao;

import br.com.stefanini.tarefa.exception.ValidacaoException;

public abstract class Validacao {

	public void lancarValidacaoException(boolean condicao, String mensagem) {
		if(condicao) {
			throw new ValidacaoException(mensagem);
		}
	}
}
