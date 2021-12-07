package com.trilha.back.financys.service;

import springfox.documentation.schema.Entry;

public interface EntryService {

    boolean validadeCategoryByIdL(long idCategory);

    Entry create (Entry entry);

    List<EntryDTO> returnListDTO();

}
