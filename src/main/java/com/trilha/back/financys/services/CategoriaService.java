package com.trilha.back.financys.services;

import com.trilha.back.financys.dtos.CategoriaDTO;
import com.trilha.back.financys.dtos.LancamentosDTO;
import com.trilha.back.financys.entities.CategoriaEntity;
import com.trilha.back.financys.entities.LancamentosEntity;
import com.trilha.back.financys.exceptions.CategoriaNotFoundException;
import com.trilha.back.financys.repositories.CategoriaRepository;
import javassist.NotFoundException;
import net.bytebuddy.jar.asm.commons.Remapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class
CategoriaService {

    public CategoriaService(CategoriaRepository repository, ModelMapper modelMapper) {
        this.categoriaRepository = repository;
        this.modelMapper = modelMapper;
    }

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private ModelMapper modelMapper;

    public CategoriaEntity save(CategoriaDTO categoriaDTO) {
        return categoriaRepository.save(mapToCategoria(categoriaDTO));
    }

    public List<CategoriaDTO> getAll() {
        return categoriaRepository.findAll()
            .stream()
            .map(this::mapToDTO).collect(Collectors.toList());
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

    public void update(Long id) {
        CategoriaDTO categoriaDto = new CategoriaDTO();
        CategoriaEntity categoriaEntity = categoriaRepository.findById(id).orElseThrow(() ->
                new CategoriaNotFoundException("Categoria não encontrada"));
        categoriaEntity.setName(categoriaDto.getName());
        categoriaEntity.setDescription(categoriaDto.getDescription());
        categoriaRepository.save(categoriaEntity);
    }

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

    public CategoriaEntity mapToCategoria(CategoriaDTO categoriaDTO){
        CategoriaEntity categoriaEntity = modelMapper.map(categoriaDTO, CategoriaEntity.class);
        return categoriaEntity;
    }

    public CategoriaDTO mapToDTO(CategoriaEntity categoryEntity){
        CategoriaDTO categoriaDTO = modelMapper.map(categoryEntity, CategoriaDTO.class);
        return categoriaDTO;
    }



//    public List<CategoriaEntity> getAll (CategoriaDTO dto) {
//        return categoriaRepository.findAll()
//                 .stream().map(i -> mapToDTo(dto))
//                 .collect(Collectors.toCollection(ArrayList::new));
//    }

//    public void update(Long id) throws CategoriaNotFoundException{
//        CategoriaDTO categoriaDTO = new CategoriaDTO();
//        CategoriaEntity entity = new CategoriaEntity();
//
//            if(Objects.equals(entity.getId(), categoriaRepository.findById(id)){
//                entity.setName(categoriaDTO.getName());
//                entity.setDescription(categoriaDTO.getDescription());
//                categoriaRepository.save(entity);
//            } else{
//                    throw new CategoriaNotFoundException("Categoria não encontrada");
//                }
//        }

//        throws CategoriaNotFoundException {
//            try {
//                if (Objects.equals(entity.getId(), categoriaRepository.getById(id))) {
//                    categoriaRepository.save(entity);
//                } else {
//                    throw new CategoriaNotFoundException("id já existe no banco");
//                }
//            } catch (CategoriaNotFoundException e) {
//                e.printStackTrace();
//            }
//            return categoriaRepository.save(entity);
//        }
//    }

//    public CategoriaEntity update(Long id, CategoriaEntity entity)
//            throws CategoriaNotFoundException {
//        try {
//            if (Objects.equals(entity.getId(), categoriaRepository.getById(id))) {
//                categoriaRepository.save(entity);
//            } else {
//                throw new CategoriaNotFoundException("id já existe no banco");
//            }
//        } catch (CategoriaNotFoundException e) {
//            e.printStackTrace();
//        }
//        return categoriaRepository.save(entity);
//    }

//    private CategoriaEntity mapToDTo(CategoriaDTO dto) {
//        return modelMapper.map(dto, CategoriaEntity.class);
//    }
//
//    private CategoriaEntity mapToEntity(CategoriaDTO categoriaDTO) {
//        return modelMapper.map(categoriaDTO, CategoriaEntity.class);
//    }
}

//    private LancamentosDTO mapToDto(LancamentosEntity lancamentosEntity) {
//        ModelMapper mapper = new ModelMapper();
//        LancamentosDTO lancamentosDTO = mapper.map(lancamentosEntity, LancamentosDTO.class);
//        return lancamentosDTO;
//    }
//
//    private LancamentosEntity mapToEntity(LancamentosDTO lancamentosDTO) {
//        ModelMapper mapper = new ModelMapper();
//        LancamentosEntity lancamentos = mapper.map(lancamentosDTO, LancamentosEntity.class);
//        return lancamentos;
//    }




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


