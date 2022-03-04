package com.mrfti.erp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mrfti.erp.domain.ServicoOs;

@Repository
public interface ServicoOsRepository extends JpaRepository<ServicoOs,Integer>{

}
