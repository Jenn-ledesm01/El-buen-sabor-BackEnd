package com.utn.ElBuenSabor.services;

import com.utn.ElBuenSabor.entities.ArticuloInsumo;
import com.utn.ElBuenSabor.entities.DetallePedido;
import com.utn.ElBuenSabor.repositories.BaseRepository;
import com.utn.ElBuenSabor.repositories.DetallePedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


public class DetallePedidoServiceImpl extends BaseServiceImpl<DetallePedido,Long> implements DetallePedidoService {
    @Autowired
    private DetallePedidoRepository detallePedidoRepository;

    public DetallePedidoServiceImpl(BaseRepository<DetallePedido,Long> baseRepository,DetallePedidoRepository detallePedidoRepository){
        super(baseRepository);
        this.detallePedidoRepository = detallePedidoRepository;
    }

    @Override
    public List<ArticuloInsumo> search(String filtro) throws Exception {
        try{
            List<ArticuloInsumo> articuloInsumo = detallePedidoRepository.searchNativo(filtro);
            return articuloInsumo;
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Page<ArticuloInsumo> search(String filtro, Pageable pageable) throws Exception {
        try{
            Page<ArticuloInsumo> articuloInsumo = detallePedidoRepository.searchNativo(filtro, pageable);
            return articuloInsumo;
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}