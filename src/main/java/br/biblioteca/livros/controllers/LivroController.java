package br.biblioteca.livros.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.biblioteca.livros.entidades.Autor;
import br.biblioteca.livros.entidades.Livro;
import br.biblioteca.livros.services.AutorService;
import br.biblioteca.livros.services.LivroService;

@Controller
@RequestMapping("/livros")
public class LivroController {
	
	@Autowired
	private LivroService service;

	@Autowired
	private AutorService serviceAutor;
	
	@GetMapping("/list")
	public ModelAndView index() {
		System.out.println("listei");
		return new ModelAndView("livros/index");
	}
	
	@GetMapping("/novo")
	public ModelAndView create(@ModelAttribute Livro livro) {
		ModelAndView modelAndView = new ModelAndView("livros/livro");
		Iterable<Autor> autores = serviceAutor.listaAutores();
		modelAndView.addObject("autores", autores);
		System.out.println("criei");
		return modelAndView;
	}
	
	@GetMapping("/alterar/{id}")
	public ModelAndView edit(@PathVariable("id") Long id) {
		System.out.println("alterei o numero " + id);
		Livro livro = service.buscarLivro(id);
		Iterable<Autor> autores = serviceAutor.listaAutores();
		ModelAndView modelAndView = new ModelAndView("livros/livro");
		modelAndView.addObject("autores", autores);
		modelAndView.addObject("livro", livro);
		return modelAndView;
	}
	
	@GetMapping("/excluir/{id}")
	public ModelAndView delete(@PathVariable("id") Long id) {
		System.out.println("deletei o numero " + id);
		service.apagarLivro(id);
		return new ModelAndView("redirect:/livros/list");
	}
	
	@PostMapping("/gravar")
	public ModelAndView store(@ModelAttribute("livro") @Valid Livro livro, BindingResult bindingResult) {
		System.out.println("Gravado " + livro.toString());
		if (bindingResult.hasErrors()) {
			ModelAndView modelAndView = new ModelAndView("livros/livro");
			Iterable<Autor> autores = serviceAutor.listaAutores();
			modelAndView.addObject("autores", autores);
			System.out.println("criei");
			return modelAndView;
			
		}

		service.salvaLivro(livro);
		
		return new ModelAndView("redirect:/livros/list");
		
	}
	
	@PostMapping("/atualizar")
	public ModelAndView update(Livro livro) {
		return new ModelAndView();
	}
	

}
