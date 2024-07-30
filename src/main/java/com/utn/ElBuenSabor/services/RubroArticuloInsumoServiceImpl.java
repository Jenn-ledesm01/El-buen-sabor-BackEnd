package com.utn.ElBuenSabor.services;

import com.utn.ElBuenSabor.entities.RubroArticuloInsumo;
import com.utn.ElBuenSabor.repositories.BaseRepository;
import com.utn.ElBuenSabor.repositories.RubroArticuloInsumoRepository;
import org.springframework.beans.factory.annotation.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RubroArticuloInsumoServiceImpl extends BaseServiceImpl<RubroArticuloInsumo, Long> implements RubroArticuloInsumoService {

    @Autowired
    private RubroArticuloInsumoRepository rubroArticuloInsumoRepository;

    public RubroArticuloInsumoServiceImpl(BaseRepository<RubroArticuloInsumo, Long> baseRepository, RubroArticuloInsumoRepository rubroArticuloInsumoRepository) {
        super(baseRepository);
        this.rubroArticuloInsumoRepository = rubroArticuloInsumoRepository;
    }

    @Override
    public List<RubroArticuloInsumo> search(String filtro) throws Exception {
        try{
            List<RubroArticuloInsumo> rubroArticuloInsumo = rubroArticuloInsumoRepository.searchNativo(filtro);
            return rubroArticuloInsumo;
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Page<RubroArticuloInsumo> search(String filtro, Pageable pageable) throws Exception {
        try{
            Page<RubroArticuloInsumo> rubroArticulo = rubroArticuloInsumoRepository.searchNativo(filtro, pageable);
            return rubroArticulo;
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
