package com.trilha.back.financys.repository;


import com.trilha.back.financys.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CategoryRepository extends JpaRepository<Category, Long> {
}