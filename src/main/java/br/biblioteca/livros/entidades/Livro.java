package br.biblioteca.livros.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
public class Livro {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@NotNull
	@Size(min = 8, max = 100)
	private String nome;
	
	@Min(2)
	private Integer quantidadePaginas;
	
	@ManyToOne
	@JoinColumn(name= "id_autor")
	private Autor autor;
	
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
	public Integer getQuantidadePaginas() {
		return quantidadePaginas;
	}
	public Autor getAutor() {
		return autor;
	}
	public void setAutor(Autor autor) {
		this.autor = autor;
	}
	public void setQuantidadePaginas(Integer quantidadePaginas) {
		this.quantidadePaginas = quantidadePaginas;
	}
	@Override
	public String toString() {
		return "Livro [nome=" + nome + ", quantidadePaginas=" + quantidadePaginas + "]";
	}
	
	

}
