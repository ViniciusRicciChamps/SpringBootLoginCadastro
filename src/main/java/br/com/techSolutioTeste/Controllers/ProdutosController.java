package br.com.techSolutioTeste.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import br.com.techSolutioTeste.Model.CadastroProdutos;
import br.com.techSolutioTeste.Repository.ProdutoRepository;

@Controller
public class ProdutosController {

	//Injeção de dependencia
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@RequestMapping(value ="/cadastrarProduto", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public String formulario() {
		return "produtos/formProduto";
	}
	
	@RequestMapping(value ="/cadastrarProduto", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.OK)
	public String formulario(CadastroProdutos cadastroProdutos) {
		produtoRepository.save(cadastroProdutos);
		return "produtos/formProduto";
	}
	
	@RequestMapping(value = "/produtos")
	public ModelAndView listaProdutos() {
		ModelAndView modelAndView = new ModelAndView("telaPrincipal");
		Iterable<CadastroProdutos> produto = produtoRepository.findAll();
		modelAndView.addObject("produtos", produto);
		return modelAndView;
	}
	
	 @DeleteMapping(value = "deletar")//mapeia a URL
	    @ResponseBody // descrição da resposta
	    public ResponseEntity<String> deletar(@RequestParam String idProduto){// RECEBE OS DADOS PARA SALVAR
	    	produtoRepository.deleteById(idProduto);
	    	return new ResponseEntity<String>("Usuario deletado com sucesso", HttpStatus.OK);
	    	
	    }
	
}
