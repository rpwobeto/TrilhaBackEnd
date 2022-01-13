package com.trilha.back.financys.services;

import com.trilha.back.financys.dtos.CategoriaDTO;
import com.trilha.back.financys.dtos.ChartDTO;
import com.trilha.back.financys.entities.CategoriaEntity;
import com.trilha.back.financys.exceptions.CategoriaNotFoundException;
import com.trilha.back.financys.repositories.CategoriaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    public CategoriaService(CategoriaRepository repository, ModelMapper modelMapper) {
        this.categoriaRepository = repository;
        this.modelMapper = modelMapper;
    }

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private ModelMapper modelMapper;

    public CategoriaEntity save(CategoriaDTO categoryDTO) {
        return categoriaRepository.save(mapToCategoria(categoryDTO));
    }

    public List<CategoriaEntity> getAll() {
        return categoriaRepository.findAll();
    }

    public CategoriaEntity getById(Long id) {
        Optional<CategoriaEntity> opt = categoriaRepository.findById(id);
        return opt.orElseThrow(() -> new CategoriaNotFoundException(
                "ID: " + id + " não encontrado. " + "Tipo: " + CategoriaNotFoundException.class.getName()));
    }

    public void updateById(Long id, CategoriaDTO categoriaDTO) {
        CategoriaEntity categoriaAtualiza = categoriaRepository.findById(id)
                .orElseThrow(() -> new CategoriaNotFoundException("Categoria não encontrada"));
        categoriaAtualiza.setName(categoriaDTO.getName());
        categoriaAtualiza.setDescription(categoriaDTO.getDescription());
        categoriaRepository.save(categoriaAtualiza);
    }

    public void deleteCategoria(Long id) {
        Optional<CategoriaEntity> opt = categoriaRepository.findById(id);
        try {
            if (opt.isPresent()) {
                categoriaRepository.deleteById(id);
            } else {
                throw new CategoriaNotFoundException("id não encontrado");
            }
        } catch (CategoriaNotFoundException e) {
            e.printStackTrace();
        }
    }

//    public ResponseEntity<List<CategoriaEntity>> readAll(){
//        List<CategoriaEntity> readAll = categoriaRepository.findAll();
//        return ResponseEntity.ok(readAll);
//    }
//
//    public Long idCategoryByName(String nameCategory ) {
//        CategoriaEntity read = categoriaRepository.findByName(nameCategory);
//        return read.getId();
//    }


    public CategoriaEntity mapToCategoria(CategoriaDTO categoryDTO) {
        CategoriaEntity categoriaEntity = modelMapper.map(categoryDTO, CategoriaEntity.class);
        return categoriaEntity;
    }

    public CategoriaDTO mapToDTO(CategoriaEntity categoryEntity) {
        CategoriaDTO categoriaDTO = modelMapper.map(categoryEntity, CategoriaDTO.class);
        return categoriaDTO;
    }

}