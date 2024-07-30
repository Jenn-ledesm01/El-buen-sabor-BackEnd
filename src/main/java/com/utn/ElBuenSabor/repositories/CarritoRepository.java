package com.utn.ElBuenSabor.repositories;

import com.utn.ElBuenSabor.entities.Carrito;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Page;

import java.util.List;

@Repository
public interface CarritoRepository extends BaseRepository<Carrito, Long>{

    List<Carrito> findByNumeroCarritoContaining(Integer numeroCarrito);
    Page<Carrito> findByNumeroCarritoContaining(Integer numeroCarrito, Pageable pageable);

    @Query(value = "SELECT c FROM Carrito c WHERE c.numeroCarrito = :filtro")
    List<Carrito> search(@Param("filtro") Integer filtro);

    @Query(value = "SELECT c FROM Carrito c WHERE c.numeroCarrito = :filtro")
    Page<Carrito> search(@Param("filtro") Integer filtro, Pageable pageable);
}
