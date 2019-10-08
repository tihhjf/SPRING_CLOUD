package br.com.stefanini.consultartarefa.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.stefanini.consultartarefa.entidade.Tarefa;

@Repository
public interface TarefaRepository extends CrudRepository<Tarefa, Long>{

	@Query(value = "select t from Tarefa t where t.nome = :nome")
	public Tarefa buscarPorNome(String nome);
}
