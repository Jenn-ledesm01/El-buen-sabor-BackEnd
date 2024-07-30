package com.utn.ElBuenSabor.repositories;

import com.utn.ElBuenSabor.entities.UnidadMedida;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UnidadMedidaRepository extends BaseRepository<UnidadMedida, Long> {

    @Query(
            value = "SELECT * FROM unidad_medida WHERE unidad_medida.denominacion LIKE %:filtro% OR unidad_medida.abreviatura LIKE %:filtro%",
            nativeQuery = true
    )
    List<UnidadMedida> searchNativo(@Param("filtro") String filtro);

    @Query(
            value = "SELECT * FROM unidad_medida WHERE unidad_medida.denominacion LIKE %:filtro% OR unidad_medida.abreviatura LIKE %:filtro%",
            countQuery = "SELECT count(*) FROM unidad_medida",
            nativeQuery = true
    )
    Page<UnidadMedida> searchNativo(@Param("filtro") String filtro, Pageable pageable);

}
