package com.utn.ElBuenSabor.entities;

import jakarta.persistence.*;
import lombok.*;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "carrito_producto")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class CarritoProducto extends Base{
    @NotNull
    @Column(name="cantidadProductoCarrito")
    private int cantidadProductoCarrito;

    @NotNull
    @Column(name="numeroLinea")
    private int numeroLinea;

    @NotNull
    @ManyToOne()
    @JoinColumn(name = "id_articulo_manufacturado")
    private ArticuloManufacturado articuloManufacturado;
}
