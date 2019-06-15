package br.biblioteca.livros.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.biblioteca.livros.entidades.Autor;

@Controller
@RequestMapping("/autores")
public class AutorController {
	
	@GetMapping("/list")
	public ModelAndView index() {
		System.out.println("listei");
		return new ModelAndView("autores/index");
	}
	
	@GetMapping("/novo")
	public ModelAndView create() {
		System.out.println("criei");
		return new ModelAndView("redirect:/autores/list");
	}
	
	@GetMapping("/alterar/{id}")
	public ModelAndView edit(@PathVariable("id") Long id) {
		System.out.println("alterei o numero " + id);
		return new ModelAndView("redirect:/autores/list");
	}
	
	@GetMapping("/excluir/{id}")
	public ModelAndView delete(@PathVariable("id") Long id) {
		System.out.println("deletei o numero " + id);
		return new ModelAndView("redirect:/autores/list");
	}
	
	@PostMapping("/gravar")
	public ModelAndView store(Autor autor) {
		return new ModelAndView();
	}
	
	@PostMapping("/atualizar")
	public ModelAndView update(Autor autor) {
		return new ModelAndView();
	}

}
