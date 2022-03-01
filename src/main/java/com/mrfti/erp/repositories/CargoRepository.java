package com.mrfti.erp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mrfti.erp.domain.Cargo;

@Repository
public interface CargoRepository extends JpaRepository<Cargo,Integer>{

}
