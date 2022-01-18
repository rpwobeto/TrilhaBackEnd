package com.trilha.back.financys.services;

import com.trilha.back.financys.dtos.LancamentosDTO;
import com.trilha.back.financys.entities.LancamentosEntity;
import com.trilha.back.financys.exceptions.DivisaoZeroException;
import com.trilha.back.financys.exceptions.LancamentosNotFoundException;
import com.trilha.back.financys.exceptions.ObjectNotFoundException;
import com.trilha.back.financys.repositories.LancamentosRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
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

    public List<LancamentosEntity> getAll() {
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

    public ResponseEntity<List<LancamentosEntity>> readAll() {
        List<LancamentosEntity> readAll = lancamentosRepository.findAll();
        return ResponseEntity.ok(readAll);
    }

    public Integer calculaMedia(Integer x, Integer y) throws DivisaoZeroException {

        try {
            if(y <=0){
                throw new DivisaoZeroException("DivisaoZeroException");
            }
        } catch (ArithmeticException e) {

          e.printStackTrace();
        }
        return (x/y);
    }

    public List<LancamentosEntity> getLancamentosDependentes(String date, Double amount, Boolean paid) throws LancamentosNotFoundException {
        if (date == null || amount == null){
            throw new LancamentosNotFoundException("Os parâmetros do Lançamento têm valores nulos");
        }
        List<LancamentosEntity> lancamentos = lancamentosRepository.findAll()
                .stream()
                .filter(lancamento -> lancamento.getDate().equals(date)
                        && lancamento.getAmount().equals(amount)
                        && lancamento.getPaid() == paid)
                .collect(Collectors.toList());

        if (CollectionUtils.isEmpty(lancamentos)){
            throw new ObjectNotFoundException("Objeto não encontrado");
        }
        return lancamentos;
    }

    public LancamentosEntity mapToLancamentos(LancamentosDTO lancamentosDTO) {
        return  modelMapper.map(lancamentosDTO, LancamentosEntity.class);
    }
}
