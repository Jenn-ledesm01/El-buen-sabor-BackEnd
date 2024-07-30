package com.utn.ElBuenSabor.services;

import com.utn.ElBuenSabor.dtos.DTOCambiarDatos;
import com.utn.ElBuenSabor.dtos.DTOPersonaClientes;
import com.utn.ElBuenSabor.dtos.DTORankingPersonas;
import com.utn.ElBuenSabor.entities.Persona;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Date;
import java.util.List;

public interface PersonaService extends BaseService<Persona, Long>{
    List<Persona> search(String filtro) throws Exception;
    Page<Persona> search(String filtro, Pageable pageable) throws Exception;

    Persona cambiarDatos(DTOCambiarDatos dtoCambiarDatos) throws Exception;

    List<DTOPersonaClientes> findClientes() throws Exception;

    List<Persona> findEmpleados() throws Exception;

    List<DTORankingPersonas> rankingPersonas(Date desde, Date hasta) throws Exception;

}