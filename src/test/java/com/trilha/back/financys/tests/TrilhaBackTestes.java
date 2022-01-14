package com.trilha.back.financys.tests;

import com.trilha.back.financys.entities.LancamentosEntity;
import com.trilha.back.financys.exceptions.LancamentosNotFoundException;
import com.trilha.back.financys.exceptions.NullPointerException;
import com.trilha.back.financys.repositories.LancamentosRepository;
import com.trilha.back.financys.services.LancamentosService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.ArrayList;
import java.util.List;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
public class TrilhaBackTestes {

        @InjectMocks
        private LancamentosService lancamentosService;

        @Mock
        private LancamentosRepository lancamentosRepository;

        @Test
        public void TesteLancamentos() throws LancamentosNotFoundException, NullPointerException {
            List<LancamentosEntity> lancamentos = new ArrayList<>();
            LancamentosEntity lancamento1 = new LancamentosEntity();
            lancamento1.setDate("10-10-2022");
            lancamento1.setAmount(600.00);
            lancamento1.setPaid(true);
            lancamentos.add(lancamento1);

            when(lancamentosRepository.findAll()).thenReturn(lancamentos);

            Assertions.assertFalse(lancamentosService.getAll().isEmpty());
            Assertions.assertEquals(1, lancamentosService.getLancamentosDependentes("10-10-2022", 600.00, true).size());
        }

    }

