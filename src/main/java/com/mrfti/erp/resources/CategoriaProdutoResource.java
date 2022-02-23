package com.mrfti.erp.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
	
}
