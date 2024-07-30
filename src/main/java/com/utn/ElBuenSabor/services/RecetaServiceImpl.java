package com.utn.ElBuenSabor.services;

import com.utn.ElBuenSabor.entities.Receta;
import com.utn.ElBuenSabor.repositories.BaseRepository;
import com.utn.ElBuenSabor.repositories.RecetaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecetaServiceImpl extends BaseServiceImpl<Receta, Long> implements RecetaService {

    @Autowired
    private RecetaRepository recetaRepository;


    public RecetaServiceImpl(BaseRepository<Receta, Long> baseRepository, RecetaRepository recetaRepository) {
        super(baseRepository);
        this.recetaRepository = recetaRepository;
    }


}
