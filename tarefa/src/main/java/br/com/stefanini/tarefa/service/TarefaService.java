package br.com.stefanini.tarefa.service;

import java.text.MessageFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.stefanini.tarefa.entidade.Tarefa;
import br.com.stefanini.tarefa.repository.TarefaRepository;
import br.com.stefanini.tarefa.request.dto.TarefaRequestDTO;
import br.com.stefanini.tarefa.response.dto.TarefaResponseDTO;

@Service
public class TarefaService extends BaseService {

	@Autowired
	private TarefaRepository tarefaRepository;

	public TarefaResponseDTO salvar(TarefaRequestDTO tarefaRequestDTO) {
		Tarefa tarefa = Tarefa.novo(tarefaRequestDTO);

		this.lancarValidacaoException(tarefaRepository.buscarPorNome(tarefa.getNome()) != null,
				MessageFormat.format("Ja existe uam tarefa com o nome {0}", tarefaRequestDTO.getNome()));
		

		return tarefaRepository.save(tarefa).dto();
	}

}
