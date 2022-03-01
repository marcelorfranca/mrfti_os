package com.mrfti.erp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mrfti.erp.domain.Veiculo;

@Repository
public interface VeiculoRepository  extends JpaRepository<Veiculo, Integer> {

}
