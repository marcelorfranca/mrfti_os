package com.mrfti.erp.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mrfti.erp.domain.Produto;
import com.mrfti.erp.domain.dtos.ProdutoDTO;
import com.mrfti.erp.services.ProdutoService;

@RestController
@RequestMapping(value="/produtos")
public class ProdutoResource {

	@Autowired
	private ProdutoService ProdutoService;
	
	
	@GetMapping
	public ResponseEntity<List<ProdutoDTO>> findAll() {
		List<Produto> list = ProdutoService.findAll();
		List<ProdutoDTO> listDTO = list.stream().map(obj -> new ProdutoDTO(obj)).collect(Collectors.toList()); //converter DTO
		return ResponseEntity.ok().body(listDTO);
	}
			
	@GetMapping(value="/{id}")
	public ResponseEntity<ProdutoDTO> findById(@PathVariable Integer id) {
	Produto obj  = ProdutoService.findById(id);
	return ResponseEntity.ok().body(new ProdutoDTO(obj));
	}
	
	
}
