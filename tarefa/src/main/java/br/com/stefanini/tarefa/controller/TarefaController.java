package br.com.stefanini.tarefa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.stefanini.tarefa.request.dto.TarefaRequestDTO;
import br.com.stefanini.tarefa.response.dto.TarefaResponseDTO;
import br.com.stefanini.tarefa.service.TarefaService;

@RestController
@RequestMapping(value = "/tarefas", 
				consumes = MediaType.APPLICATION_JSON_VALUE, 
				produces = MediaType.APPLICATION_JSON_VALUE)
public class TarefaController {

	@Autowired
	private TarefaService tarefaService;
	
	@PostMapping
	public TarefaResponseDTO salvar(@RequestBody TarefaRequestDTO tarefaRequestDTO) {
		return tarefaService.salvar(tarefaRequestDTO);
	}
}
