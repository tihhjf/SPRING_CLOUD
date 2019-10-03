package br.com.stefanini.tarefa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.stefanini.tarefa.entidade.Tarefa;
import br.com.stefanini.tarefa.repository.TarefaRepository;
import br.com.stefanini.tarefa.request.dto.TarefaRequestDTO;
import br.com.stefanini.tarefa.response.dto.TarefaResponseDTO;

@Service
public class TarefaService {

	@Autowired
	private TarefaRepository tarefaRepository;
	
	public TarefaResponseDTO salvar(TarefaRequestDTO tarefaRequestDTO) {
		return tarefaRepository.save(Tarefa.novo(tarefaRequestDTO)).dto();
	}
}
