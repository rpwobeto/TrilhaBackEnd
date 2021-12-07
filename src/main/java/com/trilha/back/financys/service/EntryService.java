package com.trilha.back.financys.service;

import com.trilha.back.financys.DTO.EntryDTO;
import springfox.documentation.schema.Entry;

import java.util.List;

public interface EntryService {

    boolean validadeCategoryByIdL(long idCategory);

    Entry create (Entry entry);

    List<EntryDTO> returnListDTO();

}
