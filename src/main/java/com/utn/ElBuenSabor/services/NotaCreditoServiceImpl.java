package com.utn.ElBuenSabor.services;

import com.utn.ElBuenSabor.entities.NotaCredito;
import com.utn.ElBuenSabor.repositories.BaseRepository;
import com.utn.ElBuenSabor.repositories.NotaCreditoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.*;
import java.math.BigDecimal;

@Service
public class NotaCreditoServiceImpl extends BaseServiceImpl<NotaCredito,Long> implements  NotaCreditoService{

    @Autowired
    private NotaCreditoRepository notaCreditoRepository;

    public NotaCreditoServiceImpl(BaseRepository<NotaCredito, Long> baseRepository, NotaCreditoRepository notaCreditoRepository) {
        super(baseRepository);
        this.notaCreditoRepository = notaCreditoRepository;
    }

    @Override
    public List<NotaCredito> search(String filtro) throws Exception {
        try{
            List<NotaCredito> pedido = notaCreditoRepository.searchNativo(filtro);
            return pedido;
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Page<NotaCredito> search(String filtro, Pageable pageable) throws Exception {
        try{
            Page<NotaCredito> pedido = notaCreditoRepository.searchNativo(filtro, pageable);
            return pedido;
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public BigDecimal searchMontoTotal (Date desde, Date hasta) throws Exception{
        try{
            BigDecimal buscarMonto = notaCreditoRepository.searchMontoTotal(desde, hasta);
            return buscarMonto;
        }catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}