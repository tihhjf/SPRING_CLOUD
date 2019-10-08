package br.com.stefanini.tarefa.entidade;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.lang.StringUtils;

import br.com.stefanini.tarefa.request.dto.TarefaRequestDTO;
import br.com.stefanini.tarefa.response.dto.TarefaResponseDTO;

@Table(name = "TB_TAREFA")
@Entity
public class Tarefa extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", nullable = false)
	private Long id;

	@Column(name = "NOME", length = 300, nullable = false)
	private String nome;

	@Column(name = "DESCRICAO", length = 800, nullable = true)
	private String descricao;

	@Column(name = "DATA_CRIACAO", nullable = false)
	private LocalDateTime dataCriacao;

	@Column(name = "DATA_ATUALIZACAO", nullable = false)
	private LocalDateTime dataAtualizacao;

	public Tarefa() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public LocalDateTime getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(LocalDateTime dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public LocalDateTime getDataAtualizacao() {
		return dataAtualizacao;
	}

	public void setDataAtualizacao(LocalDateTime dataAtualizacao) {
		this.dataAtualizacao = dataAtualizacao;
	}

	public static Tarefa novo(TarefaRequestDTO tarefaRequestDTO) {
		Tarefa tarefa = new Tarefa();

		tarefa.lancarValidacaoException(StringUtils.isEmpty(tarefaRequestDTO.getNome()),
				"O campo 'nome' é obrigatório");
		tarefa.lancarValidacaoException(StringUtils.isEmpty(tarefaRequestDTO.getDescricao()),
				"O campo 'descricao' é obrigatório");

		tarefa.setNome(tarefaRequestDTO.getNome());
		tarefa.setDescricao(tarefaRequestDTO.getDescricao());
		tarefa.setDataCriacao(LocalDateTime.now());
		tarefa.setDataAtualizacao(LocalDateTime.now());
		return tarefa;
	}

	public TarefaResponseDTO dto() {
		TarefaResponseDTO dto = new TarefaResponseDTO();
		dto.setId(this.id);
		dto.setNome(this.nome);
		dto.setDescricao(this.descricao);
		dto.setDataAtualizacao(this.dataAtualizacao);
		dto.setDataCriacao(this.dataCriacao);
		return dto;
	}

}
