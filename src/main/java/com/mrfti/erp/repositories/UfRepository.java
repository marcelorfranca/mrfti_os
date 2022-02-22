package com.mrfti.erp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mrfti.erp.domain.Uf;

@Repository
public interface UfRepository extends JpaRepository<Uf, Integer>{

	
	
}
