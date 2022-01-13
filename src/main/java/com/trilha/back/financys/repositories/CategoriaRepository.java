package com.trilha.back.financys.repositories;

import com.trilha.back.financys.entities.CategoriaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository<CategoriaEntity, Long> {
    CategoriaEntity findByName(String categoriaName);
}