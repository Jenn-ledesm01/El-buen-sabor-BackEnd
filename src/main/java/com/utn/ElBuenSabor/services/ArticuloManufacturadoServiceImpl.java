package com.utn.ElBuenSabor.services;

import com.utn.ElBuenSabor.dtos.DTORankingArticulosManufacturados;
import com.utn.ElBuenSabor.entities.ArticuloManufacturado;
import com.utn.ElBuenSabor.repositories.ArticuloManufacturadoRepository;
import com.utn.ElBuenSabor.repositories.BaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public class ArticuloManufacturadoServiceImpl extends BaseServiceImpl<ArticuloManufacturado,Long> implements ArticuloManufacturadoService {

    @Autowired
    private ArticuloManufacturadoRepository articuloManufacturadoRepository;

    public ArticuloManufacturadoServiceImpl(BaseRepository<ArticuloManufacturado, Long> baseRepository, ArticuloManufacturadoRepository articuloManufacturadoRepository) {
        super(baseRepository);
        this.articuloManufacturadoRepository = articuloManufacturadoRepository;
    }

    @Override
    public List<ArticuloManufacturado> search(String filtro) throws Exception {
        try {
            List<ArticuloManufacturado> articulos = articuloManufacturadoRepository.search(filtro);
            return articulos;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Page<ArticuloManufacturado> search(String filtro, Pageable pageable) throws Exception {
        try {
            Page<ArticuloManufacturado> articulos = articuloManufacturadoRepository.search(filtro, pageable);
            return articulos;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
    @Override
    public Page<ArticuloManufacturado> porRubro(String categoria, Pageable pageable) throws Exception{
        try{
            Page<ArticuloManufacturado> articuloManufacturado =articuloManufacturadoRepository.porRubro(categoria,pageable);
            return articuloManufacturado;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public List<DTORankingArticulosManufacturados> filtradoPorProductoVendido() throws Exception {
        try {
            List<DTORankingArticulosManufacturados> articulos = articuloManufacturadoRepository.filtroPorProductoVendido();
            return articulos;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public List<DTORankingArticulosManufacturados> filtradoPorProductoVendidoPorFecha(Date filtro1, Date filtro2) throws Exception {
        try {
            List<DTORankingArticulosManufacturados> articulos = articuloManufacturadoRepository.filtradoPorProductoVendidoPorFecha(filtro1, filtro2);
            return articulos;
        } catch (Exception e) {
            throw new Exception(e.getMessage());

        }
    }
}
