package com.algaworks.livros.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.algaworks.livros.model.Livro;

public interface Livros extends JpaRepository<Livro, Long> {

}
