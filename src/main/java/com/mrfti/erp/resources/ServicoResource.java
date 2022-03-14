package com.mrfti.erp.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mrfti.erp.domain.Servico;
import com.mrfti.erp.domain.dtos.ServicoDTO;
import com.mrfti.erp.services.ServicoService;


@RestController
@RequestMapping(value="/servicos")
public class ServicoResource {

	@Autowired
	private ServicoService servicoService;
	
	
	@GetMapping
	public ResponseEntity<List<ServicoDTO>> findAll() {
		List<Servico> list = servicoService.findAll();
		List<ServicoDTO> listDTO = list.stream().map(obj -> new ServicoDTO(obj)).collect(Collectors.toList()); //converter DTO
		return ResponseEntity.ok().body(listDTO);
	}
			
	@GetMapping(value="/{id}")
	public ResponseEntity<ServicoDTO> findById(@PathVariable Integer id) {
	Servico obj  = servicoService.findById(id);
	return ResponseEntity.ok().body(new ServicoDTO(obj));
	}
	
	
}
