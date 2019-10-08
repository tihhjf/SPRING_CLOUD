package br.com.stefanini.consultartarefa.service;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.stefanini.consultartarefa.entidade.Tarefa;
import br.com.stefanini.consultartarefa.repository.TarefaRepository;
import br.com.stefanini.consultartarefa.response.dto.TarefaResponseDTO;

@Service
public class TarefaService extends BaseService {

	@Autowired
	private TarefaRepository tarefaRepository;

	public TarefaResponseDTO buscarPorNome(String nome) {
		this.lancarValidacaoException(StringUtils.isEmpty(nome), "O campo 'nome' é obrigatório.");
		Tarefa tarefa = tarefaRepository.buscarPorNome(nome.trim());
		return tarefa != null ? tarefa.dto() : null;
	}

}
