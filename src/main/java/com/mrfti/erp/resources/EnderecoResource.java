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

import com.mrfti.erp.domain.Endereco;
import com.mrfti.erp.services.EnderecoService;

@RestController
@RequestMapping(value="/enderecos")
public class EnderecoResource {

	@Autowired
	private EnderecoService enderecoService;
	
	
	@GetMapping
	public ResponseEntity<List<Endereco>> findAll() {
		List<Endereco> list = enderecoService.findAll();
		return ResponseEntity.ok().body(list);
	}
			
	@GetMapping(value="/{id}")
	public ResponseEntity<Endereco> findById(@PathVariable Integer id) {
	Endereco obj  = enderecoService.findById(id);
	return ResponseEntity.ok().body(obj);
	}
	
	
	@PostMapping
	public ResponseEntity<Endereco> create(@Valid @RequestBody Endereco obj) {
		Endereco newObj = enderecoService.create(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Endereco> update(@PathVariable Integer id,@Valid @RequestBody Endereco obj) {
		return ResponseEntity.ok().body(enderecoService.update(id, obj));
	}
	
	@DeleteMapping(value= "/{id}")
	public ResponseEntity<Endereco> delete(@PathVariable Integer id) {
		enderecoService.delete(id);
		return ResponseEntity.noContent().build();
	}
	
}
