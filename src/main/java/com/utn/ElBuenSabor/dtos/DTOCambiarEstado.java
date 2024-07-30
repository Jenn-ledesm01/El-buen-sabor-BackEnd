package com.utn.ElBuenSabor.dtos;

import com.utn.ElBuenSabor.enums.EstadoPedido;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;

@Getter
public class DTOCambiarEstado extends DTOBase{

    private Long idPedido;
    @Enumerated(EnumType.STRING)
    private EstadoPedido estadoPedido;

}
