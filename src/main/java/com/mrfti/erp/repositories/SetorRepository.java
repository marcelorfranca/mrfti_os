package com.mrfti.erp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mrfti.erp.domain.Setor;

@Repository
public interface SetorRepository extends JpaRepository<Setor, Integer>{


}
