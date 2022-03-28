package com.mrfti.erp.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mrfti.erp.domain.Zona;
import com.mrfti.erp.services.ZonaService;

@RestController
@RequestMapping(value="/zonas")
public class ZonaResource {

	@Autowired
	private ZonaService zonaService;
	
	
	@GetMapping
	public ResponseEntity<List<Zona>> findAll() {
		List<Zona> list = zonaService.findAll();
		return ResponseEntity.ok().body(list);
	}
			
	@GetMapping(value="/{id}")
	public ResponseEntity<Zona> findById(@PathVariable Integer id) {
	Zona obj  = zonaService.findById(id);
	return ResponseEntity.ok().body(obj);
	}
	
	
}
