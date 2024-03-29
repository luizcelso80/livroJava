package br.biblioteca.livros.entidades;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;



@Entity
public class Autor {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@NotNull
	@Size(min = 8, max = 50)
	private String nome;
	
	@OneToMany(mappedBy = "autor")
	private List<Livro> livros = new ArrayList<Livro>();
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	

}
