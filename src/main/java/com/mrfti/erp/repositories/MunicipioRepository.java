package com.mrfti.erp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mrfti.erp.domain.Municipio;

@Repository
public interface MunicipioRepository extends JpaRepository<Municipio, Integer>{

	
	
}
