package com.utn.ElBuenSabor.dtos;

import com.utn.ElBuenSabor.enums.Rol;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DTOPersonaClientes {

    private Long id;
    private String nombre;
    private String apellido;
    private String telefono;
    private String email;
    private Rol rolUsuario;

    // Construtor, getters e setters
}

