package com.utn.ElBuenSabor.repositories;

import com.utn.ElBuenSabor.entities.RubroArticuloManufacturado;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RubroArticuloManufacturadoRepository extends BaseRepository<RubroArticuloManufacturado, Long> {
    @Query(
            value = "SELECT * FROM rubro_articulo_manufacturado WHERE rubro_articulo_manufacturado.denominacion LIKE %:filtro%",
            nativeQuery = true
    )
    List<RubroArticuloManufacturado> searchNativo(@Param("filtro") String filtro);

    @Query(
            value = "SELECT * FROM rubro_articulo_manufacturado WHERE rubro_articulo_manufacturado.denominacion LIKE %:filtro%",
            countQuery = "SELECT count(*) FROM rubro_articulo_manufacturado",
            nativeQuery = true
    )
    Page<RubroArticuloManufacturado> searchNativo(@Param("filtro") String filtro, Pageable pageable);

}