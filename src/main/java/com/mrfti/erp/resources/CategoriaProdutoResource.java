package com.mrfti.erp.resources;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

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
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.mrfti.erp.domain.CategoriaProduto;
import com.mrfti.erp.services.CategoriaProdutoService;

@RestController
@RequestMapping(value="/categorias")
public class CategoriaProdutoResource {

	@Autowired
	private CategoriaProdutoService  categoriaProdutoService;
	
	
	@GetMapping
	public ResponseEntity<List<CategoriaProduto>> findAll() {
		List<CategoriaProduto> list = categoriaProdutoService.findAll();
		return ResponseEntity.ok().body(list);
	}
			
	@GetMapping(value="/{id}")
	public ResponseEntity<CategoriaProduto> findById(@PathVariable Integer id) {
	CategoriaProduto obj  = categoriaProdutoService.findById(id);
	return ResponseEntity.ok().body(obj);
	}
	
	
	@PostMapping
	public ResponseEntity<CategoriaProduto> create(@Valid @RequestBody CategoriaProduto obj) {
		CategoriaProduto newObj = categoriaProdutoService.create(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<CategoriaProduto> update(@PathVariable Integer id,@Valid @RequestBody CategoriaProduto obj) {
		return ResponseEntity.ok().body(categoriaProdutoService.update(id, obj));
	}
	
	@DeleteMapping(value= "/{id}")
	public ResponseEntity<CategoriaProduto> delete(@PathVariable Integer id) {
		categoriaProdutoService.delete(id);
		return ResponseEntity.noContent().build();
	}
	
}
