package com.trilha.back.financys.repositories;

import com.trilha.back.financys.entities.LancamentosEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LancamentosRepository extends JpaRepository<LancamentosEntity, Long> {

    List<LancamentosEntity> findByPaid(Boolean paid);
}