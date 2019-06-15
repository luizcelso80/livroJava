package br.biblioteca.livros.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.biblioteca.livros.entidades.Livro;

@Controller
@RequestMapping("/livros")
public class LivroController {
	
	@GetMapping("/list")
	public ModelAndView index() {
		System.out.println("listei");
		return new ModelAndView("livros/index");
	}
	
	@GetMapping("/novo")
	public ModelAndView create() {
		System.out.println("criei");
		return new ModelAndView("livros/novo");
	}
	
	@GetMapping("/alterar/{id}")
	public ModelAndView edit(@PathVariable("id") Long id) {
		System.out.println("alterei o numero " + id);
		return new ModelAndView("redirect:/livros/list");
	}
	
	@GetMapping("/excluir/{id}")
	public ModelAndView delete(@PathVariable("id") Long id) {
		System.out.println("deletei o numero " + id);
		return new ModelAndView("redirect:/livros/list");
	}
	
	@PostMapping("/gravar")
	public ModelAndView store(Livro livro) {
		System.out.println("Gravado " + livro.toString());
		
		ModelAndView model = new ModelAndView("/livros/criado");
		model.addObject("livro", livro);
		
		return model; 
	}
	
	@PostMapping("/atualizar")
	public ModelAndView update(Livro livro) {
		return new ModelAndView();
	}
	

}
