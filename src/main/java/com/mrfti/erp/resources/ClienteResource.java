package com.mrfti.erp.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mrfti.erp.domain.Cliente;
import com.mrfti.erp.domain.dtos.ClienteDTO;
import com.mrfti.erp.services.ClienteService;

@RestController
@RequestMapping(value="/clientes")
public class ClienteResource {

	@Autowired
	private ClienteService clienteService;
	
	
	@GetMapping
	public ResponseEntity<List<ClienteDTO>> findAll() {
		List<Cliente> list = clienteService.findAll();
		List<ClienteDTO> listDTO = list.stream().map(obj -> new ClienteDTO(obj)).collect(Collectors.toList()); //converter DTO
		return ResponseEntity.ok().body(listDTO);

	}
			
	@GetMapping(value="/{id}")
	public ResponseEntity<Cliente> findById(@PathVariable Integer id) {
	Cliente obj  = clienteService.findById(id);
	return ResponseEntity.ok().body(obj);
	}
	
	
}
