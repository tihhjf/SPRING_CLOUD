package br.com.stefanini.tarefa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.stefanini.tarefa.exception.ValidacaoException;
import br.com.stefanini.tarefa.request.dto.TarefaRequestDTO;
import br.com.stefanini.tarefa.service.TarefaService;

@RestController
@RequestMapping(value = "/incluir-tarefas")
public class TarefaController {

	@Autowired
	private TarefaService tarefaService;

	@PostMapping
	public ResponseEntity<Object> salvar(@RequestBody TarefaRequestDTO tarefaRequestDTO) {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(tarefaService.salvar(tarefaRequestDTO));
		} catch (ValidacaoException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}
	

}
