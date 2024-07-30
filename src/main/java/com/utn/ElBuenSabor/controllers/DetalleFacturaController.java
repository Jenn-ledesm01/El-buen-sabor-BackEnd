package com.utn.ElBuenSabor.controllers;

import com.utn.ElBuenSabor.entities.DetalleFactura;
import com.utn.ElBuenSabor.entities.Factura;
import com.utn.ElBuenSabor.services.DetalleFacturaServiceImpl;
import com.utn.ElBuenSabor.services.FacturaServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/detallesFacturas")
public class DetalleFacturaController extends BaseControllerImpl<DetalleFactura, DetalleFacturaServiceImpl>{
}
