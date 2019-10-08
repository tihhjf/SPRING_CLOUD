package br.com.stefanini.consultartarefa.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.stefanini.consultartarefa.exception.ValidacaoException;
import br.com.stefanini.consultartarefa.service.TarefaService;

@RestController
@RequestMapping(value = "/consultar-tarefas")
public class TarefaController {

	@Autowired
	private TarefaService tarefaService;

	@GetMapping
	public ResponseEntity<Object> consultar(@RequestParam("nome") String nome) {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(tarefaService.buscarPorNome(nome));
		} catch (ValidacaoException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}
	

}
