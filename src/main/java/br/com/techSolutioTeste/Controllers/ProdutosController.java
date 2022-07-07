package br.com.techSolutioTeste.Controllers;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
	public ModelAndView formulario(@Valid CadastroProdutos cadastroProdutos, BindingResult result,
			RedirectAttributes attributes) {
		if (result.hasErrors()) {
			ModelAndView modelAndView = new ModelAndView("produtos/formProduto");
			Iterable<CadastroProdutos> iterableProdutos = produtoRepository.findAll();
			modelAndView.addObject("produtos", iterableProdutos);
			modelAndView.addObject("produtoobj", cadastroProdutos);
			
			List<String> msg = new ArrayList<String>();
			for(ObjectError error : result.getAllErrors()) {
				msg.add(error.getDefaultMessage());
			}
			 modelAndView.addObject("msg", msg);
			return modelAndView;
		}
		produtoRepository.save(cadastroProdutos);
		ModelAndView AndView = new ModelAndView("produtos/formProduto");
		Iterable<CadastroProdutos> iterableProdutos = produtoRepository.findAll();
		AndView.addObject("produtos", iterableProdutos);
		return AndView;

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
