package com.trilha.back.financys.services;

import com.trilha.back.financys.dtos.ChartDTO;
import com.trilha.back.financys.dtos.LancamentosDTO;
import com.trilha.back.financys.entities.CategoriaEntity;
import com.trilha.back.financys.entities.LancamentosEntity;
import com.trilha.back.financys.exceptions.DivisaoZeroException;
import com.trilha.back.financys.exceptions.LancamentosNotFoundException;
import com.trilha.back.financys.repositories.LancamentosRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class LancamentosService {

    @Autowired
    private LancamentosRepository lancamentosRepository;

    @Autowired
    private ModelMapper modelMapper;

    public LancamentosEntity save(LancamentosDTO lancamentosDTO) {
        LancamentosEntity lancamentosEntity = modelMapper.map(lancamentosDTO, LancamentosEntity.class);
        lancamentosRepository.save(lancamentosEntity);
        return lancamentosEntity;
    }

    public List<LancamentosEntity> getAll(){
        return lancamentosRepository.findAll();
    }

    public LancamentosEntity getById(Long id) {
        Optional<LancamentosEntity> opt = lancamentosRepository.findById(id);
        return opt.orElseThrow(() -> new LancamentosNotFoundException(
                "ID: " + id + " não encontrado. " + "Tipo: " + LancamentosNotFoundException.class.getName()));
    }

    public void updateById(Long id, LancamentosDTO lancamentosDTO) {

        LancamentosEntity lancamentosAtualiza = lancamentosRepository.findById(id)
                .orElseThrow(() -> new LancamentosNotFoundException("Lançamento não encontrado"));
        lancamentosAtualiza.setName(lancamentosDTO.getName());
        lancamentosAtualiza.setDescription(lancamentosDTO.getDescription());
        lancamentosRepository.save(lancamentosAtualiza);
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

    public List<ChartDTO> grafico() {
        List<ChartDTO> lists= new ArrayList<>();
        lancamentosRepository.findAll()
                .stream()
                .forEach(categoriaEntity -> {
                    ChartDTO chartDto = new ChartDTO();
                    chartDto.setName(categoriaEntity.getName()); //getName ou getNameCategoriaEntity?
                    chartDto.setTotal(0.0);
                    categoriaEntity.getLancamentosEntity().forEach(lan->{
                        chartDto.setTotal(lan.getAmount() + chartDto.getTotal());
                    });
                    lists.add(chartDto);
                });
        return lists;
    }


    public Integer calculaMedia (Integer x, Integer y){

        try {
            return (x / y);
        } catch (ArithmeticException e) {
            throw new DivisaoZeroException("Nenhum número pode ser dividido por zero. ");
        }
    }

    public LancamentosEntity mapToLancamentos(LancamentosDTO lancamentosDTO) {
        LancamentosEntity lancamentosEntity = modelMapper.map(lancamentosDTO, LancamentosEntity.class);
        return lancamentosEntity;
    }

    private LancamentosDTO mapToDTO(LancamentosEntity lancamentosEntity) {
        LancamentosDTO lancamentosDTO = modelMapper.map(lancamentosEntity, LancamentosDTO.class);
        return lancamentosDTO;
    }
}
