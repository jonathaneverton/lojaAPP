package br.com.loja.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.loja.model.Produto;
import br.com.loja.model.ResponseModel;
import br.com.loja.repository.ProdutoRepository;
 
 
@RestController
@RequestMapping("/service")
public class ProdutoService {
 
	@Autowired(required=false)
	@Qualifier("ProdutoRepository")
	private ProdutoRepository produtoRepository; 
 
	/**
	 * SALVAR UM NOVO REGISTRO
	 * @param produto
	 * @return
	 */
	@RequestMapping(value="/produto", method = RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_UTF8_VALUE,produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody ResponseModel salvar(@RequestBody Produto produto){
 
		try {
			this.produtoRepository.save(produto);
			return new ResponseModel(1, "Produto cadastrado com sucesso!");
		} catch(Exception e) {
			return new ResponseModel(0, e.getMessage());			
		}
	}
 
	/**
	 * ATUALIZAR UM REGISTRO
	 * @param produto
	 * @return
	 */
	@RequestMapping(value="/produto", method = RequestMethod.PUT, consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody ResponseModel atualizar(@RequestBody Produto produto){
 
		try {
			this.produtoRepository.save(produto);		
			return new ResponseModel(1, "Produto atualizado com sucesso!");
		} catch(Exception e) {
			return new ResponseModel(0, e.getMessage());
		}
	}
 
	/**
	 * CONSULTAR TODAS OS PRODUTOS
	 * @return
	 */
	@RequestMapping(value="/produto", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody List<Produto> listar(){
		return this.produtoRepository.findAll();
	}
 
	/**
	 * BUSCAR UMA PRODUTO PELO C??DIGO DO PRODUTO
	 * @param codigo
	 * @return
	 */
	@RequestMapping(value="/produto/{codigo}", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody Produto buscar(@PathVariable("codigo") Integer codigo){
		return this.produtoRepository.findOne(codigo);
	}
 
	/***
	 * EXCLUIR UM PRODUTO PELO C??DIGO DO PRODUTO
	 * @param codigo
	 * @return
	 */
	@RequestMapping(value="/produto/{codigo}", method = RequestMethod.DELETE, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody ResponseModel excluir(@PathVariable("codigo") Integer codigo){
 
		Produto produtoModel = produtoRepository.findOne(codigo);
 
		try {
			produtoRepository.delete(produtoModel);
			return new ResponseModel(1, "Produto exclu??do com sucesso!");
 
		}catch(Exception e) {
			return new ResponseModel(0, e.getMessage());
		}
	}
 
}
