package br.com.techSolutioTeste.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.techSolutioTeste.Model.CadastroProdutos;
import br.com.techSolutioTeste.Repository.ProdutoRepository;

@Controller
public class IndexController {

	@Autowired
	private ProdutoRepository produtoRepository;
	
	@RequestMapping(value = "/")
	public ModelAndView listaProdutos() {
		ModelAndView modelAndView = new ModelAndView("produtos/telaPrincipal");
		Iterable<CadastroProdutos> produto = produtoRepository.findAll();
		modelAndView.addObject("produtos", produto);
		return modelAndView;
	}
	
}
