package com.trilha.back.financysService;

import com.trilha.back.financys.entities.LancamentosEntity;
import com.trilha.back.financys.exceptions.LancamentosNotFoundException;
import com.trilha.back.financys.exceptions.ObjectNotFoundException;
import com.trilha.back.financys.repositories.LancamentosRepository;
import com.trilha.back.financys.services.LancamentosService;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.ArrayList;
import java.util.List;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
public class TrilhaBackTestesService {

    @InjectMocks
    private LancamentosService lancamentosService;

    @Mock
    private LancamentosRepository lancamentRepository;

    @Test
    public void TestaLancamentosService() throws LancamentosNotFoundException, ObjectNotFoundException{
        List<LancamentosEntity> lancamentos = new ArrayList();
        LancamentosEntity lancamento = new LancamentosEntity();
        lancamento.setDate("10-10-2010");
        lancamento.setAmount(600.00);
        lancamento.setPaid(true);
        lancamentos.add(lancamento);

        when(lancamentRepository.findAll()).thenReturn(lancamentos);

        Assertions.assertFalse(lancamentosService.getAll().isEmpty());
        Assertions.assertEquals(1, lancamentosService.getLancamentosDependentes("10-10-2010", 600.00, true).size());
    }
}





