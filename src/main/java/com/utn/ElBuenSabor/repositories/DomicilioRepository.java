package com.utn.ElBuenSabor.repositories;

import com.utn.ElBuenSabor.entities.Domicilio;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DomicilioRepository extends BaseRepository<Domicilio, Long> {

    @Query(
            value = "SELECT * FROM domicilio WHERE domicilio.localidad LIKE %:filtro%",
            nativeQuery = true
    )
    List<Domicilio> searchNativo(@Param("filtro") String filtro);

    @Query(
            value = "SELECT * FROM domicilio WHERE domicilio.localidad LIKE %:filtro%",
            countQuery = "SELECT count(*) FROM domicilio",
            nativeQuery = true
    )
    Page<Domicilio> searchNativo(@Param("filtro") String filtro, Pageable pageable);


}