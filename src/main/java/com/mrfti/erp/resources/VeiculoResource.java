package com.mrfti.erp.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mrfti.erp.domain.Veiculo;
import com.mrfti.erp.domain.dtos.VeiculoDTO;
import com.mrfti.erp.services.VeiculoService;

@RestController
@RequestMapping(value="/veiculos")
public class VeiculoResource {

	@Autowired
	private VeiculoService  veiculoService;
	
	
	@GetMapping
	public ResponseEntity<List<VeiculoDTO>> findAll() {
		List<Veiculo> list = veiculoService.findAll();
		List<VeiculoDTO> listDTO = list.stream().map(obj -> new VeiculoDTO(obj)).collect(Collectors.toList()); //converter DTO
		return ResponseEntity.ok().body(listDTO);

	}
			
	@GetMapping(value="/{id}")
	public ResponseEntity<Veiculo> findById(@PathVariable Integer id) {
	Veiculo obj  = veiculoService.findById(id);
	return ResponseEntity.ok().body(obj);
	}
	
}
