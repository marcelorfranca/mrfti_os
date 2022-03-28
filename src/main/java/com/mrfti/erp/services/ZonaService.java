package com.mrfti.erp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mrfti.erp.domain.Zona;
import com.mrfti.erp.repositories.ZonaRepository;
import com.mrfti.erp.services.exceptions.ObjectnotFoundException;

@Service
public class ZonaService {

	@Autowired
	private ZonaRepository repository;
	
	
	public Zona findById(Integer id) {
		Optional<Zona> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectnotFoundException("Objecto não encontrado! Id: " + id));
	}
	
	public List<Zona> findAll() {
		return repository.findAll();
	}
	
}
