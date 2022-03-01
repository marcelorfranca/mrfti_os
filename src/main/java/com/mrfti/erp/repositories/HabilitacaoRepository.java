package com.mrfti.erp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mrfti.erp.domain.Habilitacao;

@Repository
public interface HabilitacaoRepository extends JpaRepository<Habilitacao, Integer> {

}
