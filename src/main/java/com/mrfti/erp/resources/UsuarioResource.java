package com.mrfti.erp.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mrfti.erp.domain.Usuario;
import com.mrfti.erp.domain.dtos.UsuarioDTO;
import com.mrfti.erp.services.UsuarioService;


@RestController
@RequestMapping(value="/usuarios")
public class UsuarioResource {

	@Autowired
	private UsuarioService service;
	
	
	@GetMapping(value="/{id}")
	public ResponseEntity<Usuario> findById(@PathVariable Integer id) { // representa toda a resposta http. tipo da resposta é <Usuario>
		Usuario obj  = service.findById(id);
		return ResponseEntity.ok().body(obj); // nao usei DTO para retornar lista dos telefones no endpoint
	}
	
	@GetMapping
	public ResponseEntity<List<UsuarioDTO>> findAll() {
		List<Usuario> list = service.findAll();
		List<UsuarioDTO> listDTO = list.stream().map(obj -> new UsuarioDTO(obj)).collect(Collectors.toList()); //converter DTO
		return ResponseEntity.ok().body(listDTO);
	
	}
	
	
	
}
