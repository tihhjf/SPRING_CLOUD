package br.com.stefanini.tarefa.component;

import org.springframework.stereotype.Component;

import br.com.stefanini.tarefa.client.TarefaClient;
import br.com.stefanini.tarefa.response.dto.TarefaResponseDTO;

@Component
public class ConsultarTarefasFallback implements TarefaClient {

	@Override
	public TarefaResponseDTO buscarPorNome(String nome) {
		return new TarefaResponseDTO();
	}

}
