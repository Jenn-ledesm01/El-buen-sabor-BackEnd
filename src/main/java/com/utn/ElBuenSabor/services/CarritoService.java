package com.utn.ElBuenSabor.services;

import com.utn.ElBuenSabor.entities.Carrito;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CarritoService extends BaseService<Carrito,Long>{
    List<Carrito> search(Integer filtro) throws Exception;
    Page<Carrito> search(Integer filtro, Pageable pageable) throws Exception;
}
