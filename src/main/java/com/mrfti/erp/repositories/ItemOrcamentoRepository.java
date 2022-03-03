package com.mrfti.erp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mrfti.erp.domain.ItemOrcamento;

@Repository
public interface ItemOrcamentoRepository extends JpaRepository<ItemOrcamento, Integer>{

}
