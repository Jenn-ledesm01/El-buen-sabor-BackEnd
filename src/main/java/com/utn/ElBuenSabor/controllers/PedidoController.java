package com.utn.ElBuenSabor.controllers;

import com.utn.ElBuenSabor.dtos.DTOCambiarEstado;
import com.utn.ElBuenSabor.entities.Pedido;
import com.utn.ElBuenSabor.services.PedidoServiceImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/pedidos")
public class PedidoController extends BaseControllerImpl<Pedido, PedidoServiceImpl>{



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

    @PutMapping("/cambiarEstado")
    public ResponseEntity<?> search(@RequestBody DTOCambiarEstado dtoCambiarEstado) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.cambiarEstado(dtoCambiarEstado));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\": \"" + e.getMessage() + "\"}"));
            }
    }

    @GetMapping("/PedidoCliente")
    public ResponseEntity<?> findPedidosCliente(@RequestParam Long idCliente){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.findPedidosCliente(idCliente));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\": \"" + e.getMessage() + "\"}"));
        }
    }


}
