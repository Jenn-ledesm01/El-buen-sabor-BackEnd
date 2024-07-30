package com.utn.ElBuenSabor.entities;

import com.utn.ElBuenSabor.enums.CategoriaProducto;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;


import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "articulo_manufacturado")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class ArticuloManufacturado extends Base {

    @NotNull
    private String denominacion;

    @NotNull
    private CategoriaProducto categoria;

    @NotNull
    @Column(length = 1000)
    private String descripcion;

    @NotNull
    @Column(name = "tiempo_estimado_cocina")
    private Integer tiempoEstimadoCocina;

    @NotNull
    @Column(name = "precio_venta", precision = 10, scale = 2)
    private BigDecimal precioVenta;

    @Column(name = "costo", precision = 10, scale = 2)
    private BigDecimal costo;

    @Column(length = 500, name = "url_imagen")
    private String urlImagen;

    @OneToMany()
    @JoinColumn(name = "id_articulo_manufacturado")
    private List<DetalleArticuloManufacturado> detalleArticuloManufacturado;

    @NotNull
    @ManyToOne()
    @JoinColumn(name = "id_rubro_articulo_manufacturado")
    private RubroArticuloManufacturado rubroArticuloManufacturado;

    @NotNull
    @OneToOne()
    @JoinColumn(name = "id_receta")
    private Receta receta;

}
