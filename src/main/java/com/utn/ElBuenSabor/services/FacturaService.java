package com.utn.ElBuenSabor.services;

import com.utn.ElBuenSabor.entities.Factura;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.*;
import java.math.BigDecimal;


public interface FacturaService extends BaseService<Factura, Long> {

    List<Factura> search(String filtro) throws Exception;

    Page<Factura> search(String filtro, Pageable pageable) throws Exception;

    BigDecimal searchTotalVentas(Date desde, Date hasta) throws Exception;
}
