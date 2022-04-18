package com.mrfti.erp.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.mrfti.erp.domain.Orcamento;
import com.mrfti.erp.domain.dtos.OrcamentoDTO;
import com.mrfti.erp.services.OrcamentoService;

@RestController
@RequestMapping(value="/orcamentos")
public class OrcamentoResource {

	@Autowired
	private OrcamentoService  orcamentoService;
	
	@GetMapping
	public ResponseEntity<List<OrcamentoDTO>> findAll() {
		List<Orcamento> list = orcamentoService.findAll();
		List<OrcamentoDTO> listDTO = list.stream().map(obj -> new OrcamentoDTO(obj)).collect(Collectors.toList()); //converter DTO
		return ResponseEntity.ok().body(listDTO);
	}
			
	@GetMapping(value="/{id}")
	public ResponseEntity<Orcamento> findById(@PathVariable Integer id) {
		Orcamento obj  = orcamentoService.findById(id);
	return ResponseEntity.ok().body(obj);
	}
	
	@GetMapping(value="/page")
	public ResponseEntity<Page<Orcamento>> findPage(
			@RequestParam(value="page", defaultValue="0") Integer page,
			@RequestParam(value="linesPerPage", defaultValue="24") Integer linesPerPage,
			@RequestParam(value="orderBy", defaultValue="id") String orderBy,
			@RequestParam(value="direction", defaultValue="DESC") String direction){
		
		
		Page<Orcamento> list = orcamentoService.findPage(page, linesPerPage, orderBy, direction);
		return ResponseEntity.ok().body(list);
	}
	
	@PostMapping
	public ResponseEntity<Void> insert(@Valid @RequestBody Orcamento obj) {
		obj = orcamentoService.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<OrcamentoDTO> update(@PathVariable Integer id,@Valid @RequestBody OrcamentoDTO objDTO) {
		Orcamento obj = orcamentoService.update(id, objDTO);
		return ResponseEntity.ok().body(new OrcamentoDTO(obj));
		
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<OrcamentoDTO> delete(@PathVariable Integer id) {
		orcamentoService.delete(id); 
		return ResponseEntity.noContent().build();
	}
	
	
	
}
