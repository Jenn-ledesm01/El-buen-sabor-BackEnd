package com.utn.ElBuenSabor.dtos;

import com.utn.ElBuenSabor.entities.Persona;
import lombok.Data;

import java.math.BigDecimal;

public class DTORankingPersonas extends DTOBase{
    private Persona persona;
    private Long cantidadPedidos;
    private BigDecimal total;

    public DTORankingPersonas(Persona persona, Long cantidadPedidos, BigDecimal total) {
        this.persona = persona;
        this.cantidadPedidos = cantidadPedidos;
        this.total = total;
    }
}
