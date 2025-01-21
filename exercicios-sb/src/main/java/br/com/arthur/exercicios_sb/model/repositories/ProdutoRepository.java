package br.com.arthur.exercicios_sb.model.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import br.com.arthur.exercicios_sb.model.entities.Produto;

public interface ProdutoRepository extends PagingAndSortingRepository<Produto, Integer>{
	
	//convenção já pronta
	public Iterable<Produto> findByNomeContainingIgnoreCase(String parteNome);
	
	//A mesma coisa de cima porém nós que criamos a convenção
	@Query("SELECT p FROM Produto p WHERE p.nome LIKE %:nome%")
	public Iterable<Produto> searchByNameLike(@Param("nome") String nome);
}
