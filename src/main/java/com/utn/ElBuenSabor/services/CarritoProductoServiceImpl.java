package com.utn.ElBuenSabor.services;

import com.utn.ElBuenSabor.entities.CarritoProducto;
import com.utn.ElBuenSabor.repositories.BaseRepository;
import com.utn.ElBuenSabor.repositories.CarritoProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarritoProductoServiceImpl extends BaseServiceImpl<CarritoProducto, Long> implements CarritoProductoService{

    @Autowired
    private CarritoProductoRepository carritoProductoRepository;

    public CarritoProductoServiceImpl(BaseRepository<CarritoProducto, Long> baseRepository, CarritoProductoRepository carritoProductoRepository) {
        super(baseRepository);
        this.carritoProductoRepository = carritoProductoRepository;
    }
}
