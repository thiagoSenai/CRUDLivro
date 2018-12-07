package com.algaworks.livros.resource;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.livros.model.Livro;
import com.algaworks.livros.repository.Livros;

@RestController
@RequestMapping("/livros")
public class LivrosResource {
	
	@Autowired
	private Livros livros;
	
	@PostMapping
	public Livro adicionar(@Valid @RequestBody Livro livro) {
		return livros.save(livro);
	}
	
	@GetMapping
	public List<Livro> listar() {
		return livros.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Livro> buscar(@PathVariable Long id) {
		Livro livro = livros.findOne(id);
		
		if (livro == null) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(livro);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Livro> atualizar(@PathVariable Long id, 
			@Valid @RequestBody Livro livro) {
		Livro existente = livros.findOne(id);
		
		if (existente == null) {
			return ResponseEntity.notFound().build();
		}
		
		BeanUtils.copyProperties(livro, existente, "id");
		
		existente = livros.save(existente);
		
		return ResponseEntity.ok(existente);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> remover(@PathVariable Long id) {
		Livro livro = livros.findOne(id);
		
		if (livro == null) {
			return ResponseEntity.notFound().build();
		}
		
		livros.delete(livro);
		
		return ResponseEntity.noContent().build();
	}
}











