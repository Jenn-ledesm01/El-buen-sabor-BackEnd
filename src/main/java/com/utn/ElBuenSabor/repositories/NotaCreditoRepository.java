package com.utn.ElBuenSabor.repositories;

import com.utn.ElBuenSabor.entities.NotaCredito;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Repository
public interface NotaCreditoRepository extends BaseRepository<NotaCredito,Long> {

    @Query(
            value = "SELECT * FROM nota_credito WHERE nota_credito.persona LIKE %:filtro%",
            nativeQuery = true
    )
    List<NotaCredito> searchNativo(@Param("filtro") String filtro);

    @Query(
            value = "SELECT * FROM nota_credito WHERE nota_credito.persona LIKE %:filtro%",
            countQuery = "SELECT count(*) FROM nota_credito",
            nativeQuery = true
    )
    Page<NotaCredito> searchNativo(@Param("filtro") String filtro, Pageable pageable);

    @Query(value = "SELECT SUM(monto) FROM nota_credito as nc WHERE nc.fechaAlta BETWEEN :desde AND :hasta"
            , nativeQuery = true)
    public BigDecimal searchMontoTotal(@Param("desde") Date desde, @Param("hasta") Date hasta);


}