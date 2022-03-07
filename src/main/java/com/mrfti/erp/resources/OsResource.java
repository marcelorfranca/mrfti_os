package com.mrfti.erp.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mrfti.erp.domain.Os;
import com.mrfti.erp.services.OsService;

@RestController
@RequestMapping(value="/os")
public class OsResource {

	@Autowired
	private OsService  OsService;
	
	
	@GetMapping
	public ResponseEntity<List<Os>> findAll() {
		List<Os> list = OsService.findAll();
		return ResponseEntity.ok().body(list);
		

	}
			
	@GetMapping(value="/{id}")
	public ResponseEntity<Os> findById(@PathVariable Integer id) {
	Os obj  = OsService.findById(id);
	return ResponseEntity.ok().body(obj);
	}
	
}
