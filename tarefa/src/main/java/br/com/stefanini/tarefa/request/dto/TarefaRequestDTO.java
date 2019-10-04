package br.com.stefanini.tarefa.request.dto;

public class TarefaRequestDTO {

	private String nome;
	private String Descricao;
	
	public TarefaRequestDTO() {
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return Descricao;
	}

	public void setDescricao(String descricao) {
		Descricao = descricao;
	}

}
