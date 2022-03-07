package com.mrfti.erp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mrfti.erp.domain.Os;
import com.mrfti.erp.repositories.OsRepository;
import com.mrfti.erp.services.exceptions.ObjectnotFoundException;

@Service
public class OsService {

	@Autowired
	private OsRepository repository;
	
	public Os findById(Integer id) {
		Optional<Os> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectnotFoundException("Objecto não encontrado! Id: " + id));
	}
	
	public List<Os> findAll() {
		return repository.findAll();
	}
	
}
