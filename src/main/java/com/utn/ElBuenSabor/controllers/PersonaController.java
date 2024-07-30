package com.utn.ElBuenSabor.controllers;


import com.utn.ElBuenSabor.dtos.DTOCambiarDatos;
import com.utn.ElBuenSabor.dtos.DTOPersonaClientes;
import com.utn.ElBuenSabor.entities.Persona;
import com.utn.ElBuenSabor.services.PersonaServiceImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/personas")
public class PersonaController extends BaseControllerImpl<Persona, PersonaServiceImpl>{

    @GetMapping("/search")
    public ResponseEntity<?> search(@RequestParam String filtro){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.search(filtro));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\": \"" + e.getMessage() + "\"}"));
        }
    }

    @GetMapping("/searchPaged")
    public ResponseEntity<?> search(@RequestParam String filtro, Pageable pageable){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.search(filtro, pageable));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\": \"" + e.getMessage() + "\"}"));
        }
    }

    @PutMapping("/cambiarDatos")
    public ResponseEntity<?> search(@RequestBody DTOCambiarDatos dtoCambiarDatos) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.cambiarDatos(dtoCambiarDatos));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error. Por favor, intente más tarde.\"}");
        }
    }

    @GetMapping("/rankingPersonas")
    public ResponseEntity<?> rankingPersonas(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date desde, @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)  Date hasta) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.rankingPersonas(desde, hasta));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error. Por favor, intente más tarde.\"}");
        }
    }

    @GetMapping("/clientes")
    public ResponseEntity<?> findClientes() {
        try {
            List<DTOPersonaClientes> clientes = servicio.findClientes();
            return ResponseEntity.status(HttpStatus.OK).body(clientes);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\": \"" + e.getMessage() + "\"}");
        }
    }

    @GetMapping("/empleados")
    public ResponseEntity<?> findEmpleados() {
        try {
            List<Persona> empleados = servicio.findEmpleados();
            return ResponseEntity.status(HttpStatus.OK).body(empleados);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\": \"" + e.getMessage() + "\"}");
        }
    }

}
