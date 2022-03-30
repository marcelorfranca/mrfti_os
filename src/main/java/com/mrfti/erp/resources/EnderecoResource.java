package com.mrfti.erp.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
	
	@DeleteMapping(value= "/{id}")
	public ResponseEntity<Endereco> delete(@PathVariable Integer id) {
		enderecoService.delete(id);
		return ResponseEntity.noContent().build();
	}
	
}
