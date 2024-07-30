package com.utn.ElBuenSabor.services;

import com.utn.ElBuenSabor.entities.RubroArticuloManufacturado;
import com.utn.ElBuenSabor.repositories.BaseRepository;
import com.utn.ElBuenSabor.repositories.RubroArticuloManufacturadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RubroArticuloManufacturadoServiceImpl extends BaseServiceImpl<RubroArticuloManufacturado, Long> implements RubroArticuloManufacturadoService {
    @Autowired
    private RubroArticuloManufacturadoRepository rubroArticuloManufacturadoRepository;

    public RubroArticuloManufacturadoServiceImpl(BaseRepository<RubroArticuloManufacturado, Long> baseRepository, RubroArticuloManufacturadoRepository rubroArticuloManufacturadoRepository) {
        super(baseRepository);
        this.rubroArticuloManufacturadoRepository = rubroArticuloManufacturadoRepository;
    }
    @Override
    public List<RubroArticuloManufacturado> search(String filtro) throws Exception {
        try{
            List<RubroArticuloManufacturado> rubroArticuloManufacturado = rubroArticuloManufacturadoRepository.searchNativo(filtro);
            return rubroArticuloManufacturado;
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Page<RubroArticuloManufacturado> search(String filtro, Pageable pageable) throws Exception {
        try {
            Page<RubroArticuloManufacturado> rubroArticuloManufacturado = rubroArticuloManufacturadoRepository.searchNativo(filtro, pageable);
            return rubroArticuloManufacturado;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
