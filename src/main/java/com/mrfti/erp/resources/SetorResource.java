package com.mrfti.erp.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mrfti.erp.domain.Setor;
import com.mrfti.erp.services.SetorService;

@RestController
@RequestMapping(value="/setores")
public class SetorResource {

	@Autowired
	private SetorService setorService;
	
	
	@GetMapping
	public ResponseEntity<List<Setor>> findAll() {
		List<Setor> list = setorService.findAll();
		return ResponseEntity.ok().body(list);
	}
			
	@GetMapping(value="/{id}")
	public ResponseEntity<Setor> findById(@PathVariable Integer id) {
	Setor obj  = setorService.findById(id);
	return ResponseEntity.ok().body(obj);
	}
	
	
}
