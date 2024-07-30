package com.utn.ElBuenSabor.entities;

import jakarta.persistence.*;
import lombok.*;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "receta")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class Receta extends Base {

    @NotNull
    @Column(name = "receta")
    private String descripcionReceta;

    @NotNull
    @Column(name = "nombre_receta")
    private String nombreReceta;

    @NotNull
    @Column(name = "tiempo_receta")
    private double tiempoPreparacion;
}
