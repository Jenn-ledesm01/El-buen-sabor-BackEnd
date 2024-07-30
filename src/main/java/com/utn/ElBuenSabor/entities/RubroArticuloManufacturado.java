package com.utn.ElBuenSabor.entities;

import jakarta.persistence.*;
import lombok.*;
import jakarta.validation.constraints.NotNull;


@Entity
@Table(name = "rubro_articulo_manufacturado")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class RubroArticuloManufacturado extends Base{

    @ManyToOne()
    @JoinColumn(name = "id_rubro_padre")
    private RubroArticuloManufacturado rubroPadre;

    //@OneToMany(mappedBy = "rubroPadre", cascade = CascadeType.ALL)
    //private List<RubroArticuloManufacturado> subRubros = new ArrayList<>();

    @NotNull
    private String denominacion;
}
