package br.com.stefanini.tarefa.message;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface TarefaSource {

	@Output("incluir-tarefa-message")
	public MessageChannel sendMessage();
}
