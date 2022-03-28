package com.mrfti.erp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mrfti.erp.domain.Setor;
import com.mrfti.erp.repositories.SetorRepository;
import com.mrfti.erp.services.exceptions.ObjectnotFoundException;

@Service
public class SetorService {

	@Autowired
	private SetorRepository repository;
	
	
	public Setor findById(Integer id) {
		Optional<Setor> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectnotFoundException("Objecto não encontrado! Id: " + id));
	}
	
	public List<Setor> findAll() {
		return repository.findAll();
	}
	
}
