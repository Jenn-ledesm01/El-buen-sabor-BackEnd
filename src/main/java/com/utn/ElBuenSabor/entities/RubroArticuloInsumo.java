package com.utn.ElBuenSabor.entities;

import jakarta.persistence.*;

import lombok.*;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "rubro_articulo_insumo")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class RubroArticuloInsumo extends Base {

    @ManyToOne()
    @JoinColumn(name = "id_rubro_padre")
    private RubroArticuloInsumo rubroPadre;

    //@OneToMany(mappedBy = "rubroPadre", cascade = CascadeType.ALL)
    //private List<RubroArticulo> subRubros = new ArrayList<>();

    @NotNull
    private String denominacion;

    // asi estaba antes
  /*public RubroArticulo(String denominacion, RubroArticulo rubroPadre) {
        this.denominacion = denominacion;
        this.rubroPadre = rubroPadre;
    }
    */
    //public void setRubroPadre(RubroArticulo rubroPadre) {
    //this.rubroPadre = rubroPadre;
    //}

    //public void agregarSubRubro(RubroArticulo rubroArticulo) {
    //subRubros.add(rubroArticulo);
    // }

}
