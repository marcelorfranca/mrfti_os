package com.mrfti.erp.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mrfti.erp.domain.Uf;
import com.mrfti.erp.services.UfService;

@RestController
@RequestMapping(value="/ufs")
public class UfResource {

	@Autowired
	private UfService ufService;
	
	@GetMapping
	public ResponseEntity<List<Uf>> findAll() {
		List<Uf> list = ufService.findAll();
		return ResponseEntity.ok().body(list);
	}
			
	@GetMapping(value="/{id}")
	public ResponseEntity<Uf> findById(@PathVariable Integer id) {
	Uf obj  = ufService.findById(id);
	return ResponseEntity.ok().body(obj);
	}
	
	
}
