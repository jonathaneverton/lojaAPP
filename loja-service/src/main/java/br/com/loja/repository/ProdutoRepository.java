package br.com.loja.repository;

import java.util.List;

import org.springframework.data.repository.Repository;

import br.com.loja.model.Produto;

public interface ProdutoRepository extends Repository<Produto, Integer> {
	 
	void save(Produto produto);
 
	void delete(Produto produto);
 
	List<Produto> findAll();
 
	Produto findOne(Integer idProduto);
}
