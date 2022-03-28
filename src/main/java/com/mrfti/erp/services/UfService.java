package com.mrfti.erp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mrfti.erp.domain.Uf;
import com.mrfti.erp.repositories.UfRepository;
import com.mrfti.erp.services.exceptions.ObjectnotFoundException;

@Service
public class UfService {

	@Autowired
	private UfRepository repository;
	
	
	public Uf findById(Integer id) {
		Optional<Uf> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectnotFoundException("Objecto não encontrado! Id: " + id));
	}
	
	public List<Uf> findAll() {
		return repository.findAll();
	}
	
}
