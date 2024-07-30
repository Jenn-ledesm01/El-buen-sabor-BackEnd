package com.utn.ElBuenSabor.services;

import com.utn.ElBuenSabor.entities.UnidadMedida;
import com.utn.ElBuenSabor.repositories.BaseRepository;
import com.utn.ElBuenSabor.repositories.UnidadMedidaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UnidadMedidaServiceImpl extends BaseServiceImpl<UnidadMedida, Long> implements UnidadMedidaService{

    @Autowired
    private UnidadMedidaRepository unidadMedidaRepository;

    public UnidadMedidaServiceImpl(BaseRepository<UnidadMedida, Long> baseRepository, UnidadMedidaRepository unidadMedidaRepository) {
        super(baseRepository);
        this.unidadMedidaRepository = unidadMedidaRepository;
    }

    @Override
    public List<UnidadMedida> search(String filtro) throws Exception {
        try{
            List<UnidadMedida> unidadMedida = unidadMedidaRepository.searchNativo(filtro);
            return unidadMedida;
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Page<UnidadMedida> search(String filtro, Pageable pageable) throws Exception {
        try{
            Page<UnidadMedida> unidadMedida = unidadMedidaRepository.searchNativo(filtro, pageable);
            return unidadMedida;
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}