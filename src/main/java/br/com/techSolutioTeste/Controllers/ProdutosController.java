package br.com.techSolutioTeste.Controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

	// Injeção de dependencia
	@Autowired
	private ProdutoRepository produtoRepository;

	@RequestMapping(value = "/adicionarProduto", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public String formulario() {
		return "produtos/formProduto";
	}
	
	@RequestMapping(value = "/adicionado", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.OK)
	public String formulario(CadastroProdutos cadastroProdutos) {
		produtoRepository.save(cadastroProdutos);
		return "redirect:/produtos";
	}

	
	@RequestMapping("/produtos")
	@ResponseStatus(HttpStatus.OK)
	public ModelAndView listaProdutos() {
		ModelAndView modelAndView = new ModelAndView("produtos/telaPrincipal");
		Iterable<CadastroProdutos> produto = produtoRepository.findAll();
		modelAndView.addObject("produtos", produto);
		return modelAndView;
	}

	@GetMapping(value = "/deletarproduto/{idProduto}")
	public ModelAndView deletar(@PathVariable("idProduto") Long idProduto) {
		produtoRepository.deleteById(idProduto);
		ModelAndView modelAndView = new ModelAndView("produtos/telaPrincipal");
		modelAndView.addObject("produtos", produtoRepository.findAll());
		return modelAndView;
		
	}

}
