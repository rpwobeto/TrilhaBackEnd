package com.trilha.back.financys.services;

import com.trilha.back.financys.dtos.CategoriaDTO;
import com.trilha.back.financys.entities.CategoriaEntity;
import com.trilha.back.financys.exceptions.CategoriaNotFoundException;
import com.trilha.back.financys.repositories.CategoriaRepository;
import javassist.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class

CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private ModelMapper modelMapper;

    public CategoriaEntity save(CategoriaDTO categoriaDTO) {
        return categoriaRepository.save(mapToEntity(categoriaDTO));
    }

    public List<CategoriaEntity> getAll() {
        return new ArrayList<>(categoriaRepository.findAll());
    }

    public CategoriaEntity getById(Long id) {
        Optional<CategoriaEntity> opt = categoriaRepository.findById(id);
        try {
            if (opt.isPresent()) {
                categoriaRepository.getById(id);
            } else {
                throw new NotFoundException("id não encontrado");
            }
        } catch (NotFoundException e) {
            e.printStackTrace();
        }
        return categoriaRepository.getById(id);
    }

    public CategoriaEntity update(Long id, CategoriaEntity entity) throws CategoriaNotFoundException {

        try {
            if (Objects.equals(entity.getId(), categoriaRepository.getById(id))) {
                categoriaRepository.save(entity);
            } else {
                throw new CategoriaNotFoundException("id já existe no banco");
            }
        } catch (CategoriaNotFoundException e) {
            e.printStackTrace();
        }
        return categoriaRepository.save(entity);
    }


//    public void updateCategory(Long id) {
//       CategoriaDTO categoriaDTO = new CategoriaDTO();
//
//       CategoriaEntity ca
//
//            if (categoriaRepository.findById(id) == ) {
//                categoriaEntity.setId(categoriaEntity.getId());
//                categoriaEntity.setName(categoriaDTO.getName());
//                categoriaEntity.setDescription(categoriaDTO.getDescription());
//    }

    // throw new CategoriaFoundException("ID já existente");
//    public CategoriaEntity update(Long id, CategoriaDTO categoriaDTO){
//        Optional<CategoriaEntit> opt = categoriaRepository.findById(id);
//
//            if (opt.isEmpty()){
//                throw new CategoriaNotFoundException(String.format("Categoria com id: '%s' não encontrada" , id));
//            }
//
//            CategoriaEntity categoriaEntity = opt.get();
//
//            categoriaEntity.setName(categoriaDTO.getName());
//            categoriaEntity.setDescription(categoriaDTO.getDescription());
//
//            return categoriaEntity;
//
//    }

    public void deleteCategory(Long id) {
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

    private CategoriaEntity mapToDTo(CategoriaDTO dto) {
        return modelMapper.map(dto, CategoriaEntity.class);
    }

    private CategoriaEntity mapToEntity(CategoriaDTO categoriaDTO) {
        return modelMapper.map(categoriaDTO, CategoriaEntity.class);
    }
}

//        if( categoriaRepository.findById(id).isPresent()){
//            categoriaRepository.save(categoria);
//        }else{
//            throw new CategoriaNotFoundException("id não encontrado");
//        }
//        return ResponseEntity.ok().build();


     /*   CategoriaDTO categoriaDto = new CategoriaDTO();
        CategoriaEntity categoria = categoriaRepository.findById(id).orElseThrow(() ->
                new CategoriaNotFoundException("A categoria não foi encontrada"));
        categoria.setName(categoriaDto.getName());
        categoria.setDescription(categoriaDto.getDescription());
        categoriaRepository.save(categoria);*/


//     if (categoriaRepository.existsById(id)) {
//        categoriaRepository.deleteById(id);
//    } else {
//        throw new CategoriaNotFoundException("id não encontado");
//    }
//        return deleteCategory(id);

//    private CategoriaDTO mapToDTO(CategoriaEntity categoria) {
//        return modelMapper.map(categoria, CategoriaDTO.class);
//    }
//    private CategoriaEntity mapToEntity(CategoriaEntity dto) {
//        return modelMapper.map(dto, CategoriaEntity.class);
//    }


