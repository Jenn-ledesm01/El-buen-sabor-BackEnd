package com.utn.ElBuenSabor.controllers;

import com.utn.ElBuenSabor.entities.CarritoProducto;
import com.utn.ElBuenSabor.services.CarritoProductoServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/carritoProducto")
public class CarritoProductoController extends BaseControllerImpl<CarritoProducto, CarritoProductoServiceImpl>{
}
