package com.utn.ElBuenSabor.services;

import com.utn.ElBuenSabor.entities.Carrito;
import com.utn.ElBuenSabor.repositories.BaseRepository;
import com.utn.ElBuenSabor.repositories.CarritoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarritoServiceImpl extends BaseServiceImpl<Carrito, Long> implements CarritoService{
    @Autowired
    private CarritoRepository carritoRepository;

    public CarritoServiceImpl(BaseRepository<Carrito, Long> baseRepository, CarritoRepository carritoRepository) {
        super(baseRepository);
        this.carritoRepository = carritoRepository;
    }

    @Override
    public List<Carrito> search(Integer filtro) throws Exception{
        try{
            List<Carrito> carritos = carritoRepository.search(filtro);
            return carritos;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Page<Carrito> search(Integer filtro, Pageable pageable) throws Exception{
        try{
            Page<Carrito> carritos = carritoRepository.search(filtro,pageable);
            return carritos;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
