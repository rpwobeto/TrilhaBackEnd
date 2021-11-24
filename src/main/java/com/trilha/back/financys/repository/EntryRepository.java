package com.trilha.back.financys.repository;

import com.trilha.back.financys.entities.Entry;
import org.springframework.data.repository.CrudRepository;

public interface EntryRepository extends CrudRepository<Entry, Long> {

}