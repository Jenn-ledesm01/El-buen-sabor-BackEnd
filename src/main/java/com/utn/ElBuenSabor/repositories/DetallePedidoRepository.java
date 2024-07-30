package com.utn.ElBuenSabor.repositories;

import com.utn.ElBuenSabor.entities.ArticuloInsumo;
import com.utn.ElBuenSabor.entities.DetallePedido;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DetallePedidoRepository extends BaseRepository<DetallePedido, Long> {

    @Query(
            value = "SELECT * FROM articulo_insumo WHERE articulo_insumo.denominacion LIKE %:filtro%",
            nativeQuery = true
    )
    List<ArticuloInsumo> searchNativo(@Param("filtro") String filtro);

    @Query(
            value = "SELECT * FROM articulo_insumo WHERE articulo_insumo.denominacion LIKE %:filtro%",
            countQuery = "SELECT count(*) FROM articulo_insumo",
            nativeQuery = true
    )
    Page<ArticuloInsumo> searchNativo(@Param("filtro") String filtro, Pageable pageable);

}