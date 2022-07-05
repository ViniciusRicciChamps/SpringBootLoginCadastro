package br.com.techSolutioTeste.Repository;

import org.springframework.data.repository.CrudRepository;

import br.com.techSolutioTeste.Model.CadastroProdutos;

public interface ProdutoRepository  extends CrudRepository<CadastroProdutos, String>{

}
