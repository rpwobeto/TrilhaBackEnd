package com.trilha.back.financys.services;

import com.trilha.back.financys.dtos.CategoriaDTO;
import com.trilha.back.financys.dtos.LancamentosDTO;
import com.trilha.back.financys.entities.CategoriaEntity;
import com.trilha.back.financys.entities.LancamentosEntity;
import com.trilha.back.financys.exceptions.DivisaoZeroException;
import com.trilha.back.financys.exceptions.LancamentosNotFoundException;
import com.trilha.back.financys.repositories.LancamentosRepository;
import javassist.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

@RequiredArgsConstructor
@Service
public class LancamentosService {

    @Autowired
    private LancamentosRepository lancamentosRepository;

    @Autowired
    private ModelMapper modelMapper;
//    @Autowired
//    private CategoriaRepository categoriaRepository;

//    private List<LancamentosDTO> lancamentosDTO = new ArrayList<>();

//    public LancamentosEntity save (LancamentosEntity lancamentos){
//        return lancamentosRepository.save(lancamentos);
//    }

    public LancamentosEntity save(LancamentosDTO lancamentosDTO) {
        return lancamentosRepository.save(mapToEntity(LancamentosEntity.builder().build()));
    }


    public List<LancamentosEntity> getAll() {
        return new ArrayList<>(lancamentosRepository.findAll());
    }

    public LancamentosEntity getById(Long id) {
        Optional<LancamentosEntity> opt = lancamentosRepository.findById(id);
        try {
            if (opt.isPresent()) {
                lancamentosRepository.getById(id);
            } else {
                throw new NotFoundException("id não encontrado");
            }
        } catch (NotFoundException e) {
            e.printStackTrace();
        }
        return lancamentosRepository.getById(id);
    }


    public LancamentosEntity update(Long id, LancamentosDTO lancamentosDTO) throws LancamentosNotFoundException {
        Optional<LancamentosEntity> opt = lancamentosRepository.findById(id);
        try {
            if (opt.isPresent()) {
                lancamentosRepository.save(mapToDTo(lancamentosDTO));
            } else {
                throw new LancamentosNotFoundException("id já existe no banco");
            }
        } catch (LancamentosNotFoundException e) {
            e.printStackTrace();
        }
        return lancamentosRepository.save(mapToDTo(lancamentosDTO));
    }

    public void deleteLancamentos(Long id) {
        Optional<LancamentosEntity> opt = lancamentosRepository.findById(id);
        try {
            if (opt.isPresent()) {
                lancamentosRepository.deleteById(id);
            } else {
                throw new LancamentosNotFoundException("id não encontrado");
            }
        } catch (LancamentosNotFoundException e) {
            e.printStackTrace();
        }
    }
    public Integer calculaMedia (Integer x, Integer y){
        try {
            return (x / y);
        } catch (ArithmeticException e) {
            throw new DivisaoZeroException("Nenhum número pode ser dividido por zero.");
        }
    }

    private LancamentosEntity mapToDTo(LancamentosDTO dto) {
        return modelMapper.map(dto, LancamentosEntity.class);
    }

    private LancamentosEntity mapToEntity(LancamentosEntity lancamentosDTO) {
        return modelMapper.map(lancamentosDTO, LancamentosEntity.class);
    }
}


//    public void create(LancamentosEntity lancamentos) throws LancamentosNotFoundException {
//        long idCategory = 0;
//        try {
//            if (validadeCategoryByIdL(idCategory)) {
//                lancamentosRepository.save(mapToEntity(lancamentos));
//            } else {
//                throw new LancamentosNotFoundException("categoria já registrada!");
//            }
//        } catch (LancamentosNotFoundException lancamentosNotFoundException) {
//            lancamentosNotFoundException.printStackTrace();
//        }
//    }

//    private boolean validadeCategoryByIdL(long idCategory) {
//        Optional<CategoriaEntity> category = categoriaRepository.findById(idCategory);
//        return category.isPresent();
//    }
//
//    public List<LancamentosEntity> getAll(LancamentosEntity lancamentos) {
//
//        try {
//            List<LancamentosEntity> list = new ArrayList<>();
//
//            if (list.size() < 0) {
//                ResponseEntity.status(400);
//            } else {
//                return lancamentosRepository.findAll(lancamentos);
//            }
//        }finally
//
//
//            public ResponseEntity<Optional<LancamentosEntity>> getById (Long id){
//
//                if (lancamentosRepository.findById(id).isPresent()) {
//                    lancamentosRepository.getById(id);
//                } else {
//                    ResponseEntity.status(400);
//                }
//                return ResponseEntity.ok().body(lancamentosRepository.findById(id));
//            }
//
//            public ResponseEntity update (Long id, LancamentosEntity lancamentos){
//                lancamentos.setId(id);
//                lancamentosRepository.save(lancamentos);
//                return ResponseEntity.status(HttpStatus.OK).build();
//            }
//
//            public void deleteEntry (Long id) throws IllegalArgumentException {
//                try {
//                    if (id != null) {
//                        lancamentosRepository.deleteById(id);
//
//                    } else {
//                        throw new LancamentosNotFoundException("categoria já registrada!");
//                    }
//                } catch (BuilderExceptions builderExceptions) {
//                    builderExceptions.printStackTrace();
//                }
//            }
//
//
//    private CategoriaEntity mapToDTo(CategoriaDTO dto) {
//        return modelMapper.map(dto, CategoriaEntity.class);
//    }
//    private CategoriaEntity mapToEntity(CategoriaDTO categoriaDTO) {
//        return modelMapper.map(categoriaDTO, CategoriaEntity.class);
//    }

