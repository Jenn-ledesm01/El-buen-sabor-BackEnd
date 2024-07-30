package com.utn.ElBuenSabor.dtos;


import lombok.Getter;

@Getter
public class DTOCambiarContrasenia extends DTOBase{
    private Long id;
    private String contraseniaActual;
    private String contraseniaNueva;

}
