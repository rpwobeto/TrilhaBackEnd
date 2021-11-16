package com.trilha.back.financys.repository;

import com.trilha.back.financys.entities.Entry;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EntryRepository extends JpaRepository<Entry, Long> {

}