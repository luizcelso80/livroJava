package br.biblioteca.livros.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.biblioteca.livros.entidades.Livro;

public interface LivroRepository extends JpaRepository<Livro, Long> {

}
