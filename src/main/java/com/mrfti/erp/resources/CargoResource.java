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

import com.mrfti.erp.domain.Cargo;
import com.mrfti.erp.services.CargoService;

@RestController
@RequestMapping(value="/cargos")
public class CargoResource {

	@Autowired
	private CargoService cargoService;
	
	
	@GetMapping
	public ResponseEntity<List<Cargo>> findAll() {
		List<Cargo> list = cargoService.findAll();
		return ResponseEntity.ok().body(list);
	}
			
	@GetMapping(value="/{id}")
	public ResponseEntity<Cargo> findById(@PathVariable Integer id) {
	Cargo obj  = cargoService.findById(id);
	return ResponseEntity.ok().body(obj);
	}
	
	
	@PostMapping
	public ResponseEntity<Cargo> create(@Valid @RequestBody Cargo obj) {
		Cargo newObj = cargoService.create(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Cargo> update(@PathVariable Integer id,@Valid @RequestBody Cargo obj) {
		return ResponseEntity.ok().body(cargoService.update(id, obj));
	}
	
	@DeleteMapping(value= "/{id}")
	public ResponseEntity<Cargo> delete(@PathVariable Integer id) {
		cargoService.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	
}
