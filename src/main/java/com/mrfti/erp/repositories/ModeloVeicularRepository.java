package com.mrfti.erp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mrfti.erp.domain.ModeloVeicular;

@Repository
public interface ModeloVeicularRepository extends JpaRepository<ModeloVeicular, Integer> {

}
