package com.utn.ElBuenSabor.controllers;


import com.utn.ElBuenSabor.dtos.DTOCambiarContrasenia;
import com.utn.ElBuenSabor.entities.Usuario;
import com.utn.ElBuenSabor.services.UsuarioServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/usuarios")
public class UsuarioController extends BaseControllerImpl<Usuario, UsuarioServiceImpl> {

    @GetMapping("/search")
    public ResponseEntity<?> search(@RequestParam String username, String password) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.search(username, password));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error, por favor intente más tarde.\"}");
        }
    }

    @GetMapping("/userName")
    public ResponseEntity<?> findByUsername(@RequestParam String username){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.findByUsername(username));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error, por favor intente más tarde.\"}");
        }
    }

    @PutMapping("/cambiarContraseña")
    public ResponseEntity<?> search(@RequestBody DTOCambiarContrasenia dtoCambiarContraseña) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.cambiarContrasena(dtoCambiarContraseña));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error. Por favor, intente más tarde.\"}");
        }
    }



}