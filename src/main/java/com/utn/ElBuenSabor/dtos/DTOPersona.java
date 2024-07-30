package com.utn.ElBuenSabor.dtos;

import com.utn.ElBuenSabor.entities.Domicilio;
import com.utn.ElBuenSabor.entities.Usuario;

import java.util.ArrayList;
import java.util.List;


public class DTOPersona extends DTOBase{

    private String nombre;
    private String apellido;

    private String telefono;

    private String email;

    private Usuario usuario;

    private List<Domicilio> domicilios = new ArrayList<>();


}
