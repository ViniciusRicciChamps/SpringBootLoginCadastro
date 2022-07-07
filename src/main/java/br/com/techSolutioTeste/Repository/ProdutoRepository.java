package br.com.techSolutioTeste.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.techSolutioTeste.Model.CadastroProdutos;


@Repository
@Transactional
public interface ProdutoRepository  extends CrudRepository<CadastroProdutos, Long>{

}
