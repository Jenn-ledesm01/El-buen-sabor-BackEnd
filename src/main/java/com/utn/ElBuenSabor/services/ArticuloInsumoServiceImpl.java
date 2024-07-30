package com.utn.ElBuenSabor.services;

import com.utn.ElBuenSabor.entities.ArticuloInsumo;
import com.utn.ElBuenSabor.repositories.ArticuloInsumoRepository;
import com.utn.ElBuenSabor.repositories.BaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticuloInsumoServiceImpl extends BaseServiceImpl<ArticuloInsumo,Long> implements ArticuloInsumoService{

    @Autowired
    private ArticuloInsumoRepository articuloInsumoRepository;

    public ArticuloInsumoServiceImpl(BaseRepository<ArticuloInsumo, Long> baseRepository, ArticuloInsumoRepository articuloInsumoRepository) {
        super(baseRepository);
        this.articuloInsumoRepository = articuloInsumoRepository;
    }

    @Override
    public List<ArticuloInsumo> search(String filtro) throws Exception {
        try{
            List<ArticuloInsumo> articuloInsumo = articuloInsumoRepository.searchNativo(filtro);
            return articuloInsumo;
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Page<ArticuloInsumo> search(String filtro, Pageable pageable) throws Exception {
        try{
            Page<ArticuloInsumo> articuloInsumo = articuloInsumoRepository.searchNativo(filtro, pageable);
            return articuloInsumo;
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
    @Override
    public Page<ArticuloInsumo> getStockBajo(Pageable pageable) throws Exception{
        try{
            Page<ArticuloInsumo> insumo=articuloInsumoRepository.getStockBajo(pageable);
            return insumo;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}