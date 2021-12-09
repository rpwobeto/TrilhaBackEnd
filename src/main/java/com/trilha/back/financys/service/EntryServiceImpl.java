package com.trilha.back.financys.service;


import com.trilha.back.financys.dto.EntryDTO;
import org.springframework.stereotype.Service;
import springfox.documentation.schema.Entry;
import java.util.List;

@Service
public class EntryServiceImpl implements EntryService{

    @Override
    public boolean validadeCategoryByIdL(long idCategory) {
        return false;
    }

    @Override
    public Entry create(Entry entry) {
        return null;
    }

    @Override
    public List<EntryDTO> returnListDTO() {
        return null;
    }

}
