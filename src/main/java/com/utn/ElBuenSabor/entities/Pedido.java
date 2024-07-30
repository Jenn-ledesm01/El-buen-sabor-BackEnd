package com.utn.ElBuenSabor.entities;

import com.utn.ElBuenSabor.enums.EstadoPedido;
import com.utn.ElBuenSabor.enums.FormaPago;
import com.utn.ElBuenSabor.enums.TipoEnvio;
import jakarta.persistence.*;

import lombok.*;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "pedido")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Pedido extends Base {

    @NotNull
    @Column(name = "fecha_pedido")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaPedido;

    @NotNull
    @Column(name = "hora_estimada_finalizacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date horaEstimadaFinalizacion;

    @NotNull
    @Column(name = "total", precision = 10, scale = 2)
    private BigDecimal total;

    @NotNull
    @Column(name = "total_costo", precision = 10, scale = 2)
    private BigDecimal totalCosto;

    @NotNull
    @Column(name = "estado")
    @Enumerated(EnumType.STRING)
    private EstadoPedido estado;

    @NotNull
    @Column(name = "tipo_envio")
    @Enumerated(EnumType.STRING)
    private TipoEnvio tipoEnvio;

    @NotNull
    @Column(name = "forma_pago")
    @Enumerated(EnumType.STRING)
    private FormaPago formaPago;

    @ManyToOne()
    @JoinColumn(name = "id_domicilio_entrega")
    private Domicilio domicilioEntrega;

    @NotNull
    @ManyToOne()
    @JoinColumn(name = "id_cliente")
    private Persona persona;

    @NotNull
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "id_factura")
    private Factura factura;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    @JoinColumn(name = "id_pedido")
    @Builder.Default
    private List<DetallePedido> detalles = new ArrayList<>();

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "id_carrito")
    private Carrito carrito;


    public void agregarDetalle(DetallePedido detallePedido){

        detalles.add(detallePedido);
    }

    //MÉTODO DE MOSTRAR DETALLES
    public void mostrarDetalles(){
        int contador = 0;
        for (DetallePedido detallePedido: detalles){
            System.out.println("Línea numero: " + contador + ", Producto" + detallePedido.getArticuloManufacturado() + ", cantidad pedida: " + detallePedido.getCantidad() + ", subtotal: " + detallePedido.getSubtotal());
            contador = contador + 1;
        }
    }
}
