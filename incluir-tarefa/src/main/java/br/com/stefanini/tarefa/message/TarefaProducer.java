package br.com.stefanini.tarefa.message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

import br.com.stefanini.tarefa.response.dto.TarefaResponseDTO;

@Component
public class TarefaProducer {

	@Autowired
	private TarefaSource tarefaSource;
	
	public boolean sendMessage(TarefaResponseDTO tarefaResponseDTO) {
		Message<TarefaResponseDTO> message = MessageBuilder.withPayload(tarefaResponseDTO).build();
		return tarefaSource.sendMessage().send(message);
	}
}
