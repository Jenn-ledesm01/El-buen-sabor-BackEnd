package com.utn.ElBuenSabor.services;

import com.utn.ElBuenSabor.entities.NotaCredito;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.math.BigDecimal;
import java.util.*;

public interface NotaCreditoService extends BaseService<NotaCredito, Long>{
    List<NotaCredito> search(String filtro) throws Exception;
    Page<NotaCredito> search(String filtro, Pageable pageable) throws Exception;

    BigDecimal searchMontoTotal(Date desde, Date hasta) throws Exception;
}