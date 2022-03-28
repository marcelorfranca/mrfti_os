package com.mrfti.erp.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
	
}
