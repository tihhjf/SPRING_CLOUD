package br.com.stefanini.tarefa.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.stefanini.tarefa.response.dto.TarefaResponseDTO;

@FeignClient(name = "consultar-tarefas", path = "/consultar-tarefas")
public interface TarefaClient {

	@GetMapping
	TarefaResponseDTO buscarPorNome(@RequestParam("nome") String nome);
}
