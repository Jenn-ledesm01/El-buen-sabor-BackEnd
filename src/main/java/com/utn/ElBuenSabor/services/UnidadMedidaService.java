package com.utn.ElBuenSabor.services;

import com.utn.ElBuenSabor.entities.UnidadMedida;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UnidadMedidaService extends BaseService<UnidadMedida, Long>{

    List<UnidadMedida> search(String filtro) throws Exception;
    Page<UnidadMedida> search(String filtro, Pageable pageable) throws Exception;


}