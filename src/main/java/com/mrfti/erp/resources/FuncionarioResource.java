package com.mrfti.erp.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mrfti.erp.domain.Funcionario;
import com.mrfti.erp.domain.dtos.FuncionarioDTO;
import com.mrfti.erp.services.FuncionarioService;

@RestController
@RequestMapping(value="/funcionarios")
public class FuncionarioResource {

	@Autowired
	private FuncionarioService service;
	
	
	@GetMapping(value="/{id}")
	public ResponseEntity<Funcionario> findById(@PathVariable Integer id) { // representa toda a resposta http. tipo da resposta é <Funcionario>
		Funcionario obj  = service.findById(id);
		return ResponseEntity.ok().body(obj); // nao usei DTO para retornar lista dos telefones no endpoint
	}
	
	@GetMapping
	public ResponseEntity<List<FuncionarioDTO>> findAll() {
		List<Funcionario> list = service.findAll();
		List<FuncionarioDTO> listDTO = list.stream().map(obj -> new FuncionarioDTO(obj)).collect(Collectors.toList()); //converter DTO
		return ResponseEntity.ok().body(listDTO);
	
	}
	
	
	
}
