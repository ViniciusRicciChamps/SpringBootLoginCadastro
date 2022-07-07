package br.com.techSolutioTeste.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import br.com.techSolutioTeste.Model.CadastroProdutos;
import br.com.techSolutioTeste.Repository.ProdutoRepository;

@Controller
public class IndexController {

	@Autowired
	private ProdutoRepository produtoRepository;
	
	
	@GetMapping(value = "/")
	@ResponseStatus(HttpStatus.OK)
	public ModelAndView listaProdutos() {
		ModelAndView modelAndView = new ModelAndView("produtos/telaPrincipal");
		Iterable<CadastroProdutos> produto = produtoRepository.findAll();
		modelAndView.addObject("produtos", produto);
		return modelAndView;
	}
	
}
