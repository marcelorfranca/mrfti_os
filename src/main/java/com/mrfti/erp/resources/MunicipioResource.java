package com.mrfti.erp.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mrfti.erp.domain.Municipio;
import com.mrfti.erp.services.MunicipioService;

@RestController
@RequestMapping(value="/municipios")
public class MunicipioResource {

	@Autowired
	private MunicipioService municipioService;
	
	
	@GetMapping
	public ResponseEntity<List<Municipio>> findAll() {
		List<Municipio> list = municipioService.findAll();
		return ResponseEntity.ok().body(list);
	}
			
	@GetMapping(value="/{id}")
	public ResponseEntity<Municipio> findById(@PathVariable Integer id) {
	Municipio obj  = municipioService.findById(id);
	return ResponseEntity.ok().body(obj);
	}
	
	
}
