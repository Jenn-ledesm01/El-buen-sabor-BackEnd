package com.utn.ElBuenSabor.controllers;
import com.utn.ElBuenSabor.entities.ArticuloManufacturado;
import com.utn.ElBuenSabor.services.ArticuloManufacturadoServiceImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/articulosmanufacturados")
public class ArticuloManufacturadoController extends BaseControllerImpl<ArticuloManufacturado, ArticuloManufacturadoServiceImpl>{



    @GetMapping("/search")
    public ResponseEntity<?> search(@RequestParam String filtro){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.search(filtro));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\": \"" + e.getMessage() + "\"}"));
        }
    }

    @GetMapping("/searchPaged")
    public ResponseEntity<?> search(@RequestParam String filtro, Pageable pageable){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.search(filtro));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\": \"" + e.getMessage() + "\"}"));
        }
    }

    @GetMapping("/porRubro")
    public ResponseEntity<?> searchPorRubro(@RequestParam String categoria, Pageable pageable) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.porRubro(categoria, pageable));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\": \"" + e.getMessage() + "\"}"));
            }
    }

    @GetMapping("/rankingProducto")
    public ResponseEntity<?> filtroPorProductoVendido() {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.filtradoPorProductoVendido());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error. Por favor, intente más tarde.\"}");
        }
    }

    @GetMapping("/rankingProductoRango")
    public ResponseEntity<?> filtradoPorProductoVendidoPorFecha(@RequestParam String desde, @RequestParam String hasta) {
        try {
            java.sql.Date fechaDesde = java.sql.Date.valueOf(desde);
            java.sql.Date fechaHasta = java.sql.Date.valueOf(hasta);
            return ResponseEntity.status(HttpStatus.OK).body(servicio.filtradoPorProductoVendidoPorFecha(fechaDesde, fechaHasta));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error. Por favor, intente más tarde.\"}");
        }
    }
}