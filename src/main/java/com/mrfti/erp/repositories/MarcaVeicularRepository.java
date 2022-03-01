package com.mrfti.erp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mrfti.erp.domain.MarcaVeicular;

@Repository
public interface MarcaVeicularRepository extends JpaRepository<MarcaVeicular, Integer>{

}
