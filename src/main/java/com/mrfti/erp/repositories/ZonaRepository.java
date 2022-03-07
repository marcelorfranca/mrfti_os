package com.mrfti.erp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mrfti.erp.domain.Zona;

@Repository
public interface ZonaRepository extends JpaRepository<Zona,Integer>{

}
