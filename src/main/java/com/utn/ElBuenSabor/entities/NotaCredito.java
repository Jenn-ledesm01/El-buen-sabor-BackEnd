package com.utn.ElBuenSabor.entities;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.persistence.*;
import lombok.*;


import java.math.BigDecimal;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "nota_credito")
public class NotaCredito extends Base{
    @NotNull
    @Column(name = "total_monto", precision = 10, scale = 2)
    private BigDecimal monto;

    @OneToOne
    private Factura factura;

    @ManyToOne
    private Persona persona;

}
