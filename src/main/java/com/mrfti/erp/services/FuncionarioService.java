package com.mrfti.erp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mrfti.erp.domain.Funcionario;
import com.mrfti.erp.repositories.FuncionarioRepository;
import com.mrfti.erp.services.exceptions.ObjectnotFoundException;

@Service
public class FuncionarioService {

	@Autowired
	private FuncionarioRepository repository;
	
	
	public Funcionario findById(Integer id) {
		Optional<Funcionario> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectnotFoundException("Objecto não encontrado! Id: " + id));
	}

	public List<Funcionario> findAll() {
		return repository.findAll();
	}

	
	
}
