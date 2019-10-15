package br.com.stefanini.tarefa.service;

import java.text.MessageFormat;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.stefanini.tarefa.client.TarefaClient;
import br.com.stefanini.tarefa.entidade.Tarefa;
import br.com.stefanini.tarefa.exception.ValidacaoException;
import br.com.stefanini.tarefa.message.TarefaProducer;
import br.com.stefanini.tarefa.repository.TarefaRepository;
import br.com.stefanini.tarefa.request.dto.TarefaRequestDTO;
import br.com.stefanini.tarefa.response.dto.TarefaResponseDTO;

@Service
public class TarefaService extends BaseService {

	@Autowired
	private TarefaRepository tarefaRepository;
	
	@Autowired
	private TarefaClient tarefaClient;
	
	@Autowired
	private TarefaProducer tarefaProducer;

	public TarefaResponseDTO salvar(TarefaRequestDTO tarefaRequestDTO) {
		Tarefa tarefa = Tarefa.novo(tarefaRequestDTO);
		validarTarefaExistente(tarefa.getNome());
		
		TarefaResponseDTO tarefaSalva = tarefaRepository.save(tarefa).dto();
		tarefaProducer.sendMessage(tarefaSalva);
		
		return tarefaSalva;
	}
	
	private void validarTarefaExistente(String nome) {
		TarefaResponseDTO tarefa = tarefaClient.buscarPorNome(nome);
		
		if(Objects.nonNull(tarefa) && Objects.isNull(tarefa.getId())) {
			throw new ValidacaoException("Não foi possível estabelecer uma conexão com o micro serviço consultar-tarefas.");
		}
		if(Objects.nonNull(tarefa) && Objects.nonNull(tarefa.getId())) {
			throw new ValidacaoException(MessageFormat.format("Ja existe uam tarefa com o nome {0}", nome));
		}
		
	}

}
