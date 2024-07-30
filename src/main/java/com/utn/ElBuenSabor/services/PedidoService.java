package com.utn.ElBuenSabor.services;

import com.utn.ElBuenSabor.dtos.DTOCambiarEstado;
import com.utn.ElBuenSabor.entities.Pedido;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PedidoService extends BaseService<Pedido, Long>{

    Pedido cambiarEstado (DTOCambiarEstado cambiarEstadoDTO) throws Exception;
    List<Pedido> search(String filtro) throws Exception;
    Page<Pedido> search(String filtro, Pageable pageable) throws Exception;

    List<Pedido> findPedidosCliente(Long id) throws Exception;

}
