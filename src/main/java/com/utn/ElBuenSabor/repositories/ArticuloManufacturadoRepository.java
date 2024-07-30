package com.utn.ElBuenSabor.repositories;

import com.utn.ElBuenSabor.dtos.DTORankingArticulosManufacturados;
import com.utn.ElBuenSabor.entities.ArticuloManufacturado;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public interface ArticuloManufacturadoRepository extends BaseRepository<ArticuloManufacturado, Long> {

    @Query(
            value = "SELECT * FROM articulo_manufacturado WHERE articulo_manufacturado.denominacion LIKE %:filtro% OR articulo_manufacturado.descripcion LIKE %:filtro%",
            nativeQuery = true
    )
    List<ArticuloManufacturado> search(@Param("filtro") String filtro);

    @Query(
            value = "SELECT * FROM articulo_manufacturado WHERE articulo_manufacturado.denominacion LIKE %:filtro% ",
            countQuery = "SELECT count(*) FROM articulo_manufacturado",
            nativeQuery = true
    )
    Page<ArticuloManufacturado> search(@Param("filtro") String filtro, Pageable pageable);

    @Query(
            value = "SELECT * FROM articulo_manufacturado WHERE articulo_manufacturado.categoria LIKE %:categoria% ",
            countQuery = "SELECT count(*) FROM articulo_manufacturado",
            nativeQuery = true
    )
    Page<ArticuloManufacturado> porRubro(@Param("categoria") String categoria, Pageable pageable);

    // Ordena los productos de mas vendidos a menos
    @Query(
            value = "SELECT a.denominacion, SUM(d.cantidad) AS cantidad_productos_vendidos " +
                    "FROM articulo_manufacturado a " +
                    "INNER JOIN detalle_factura d ON a.id = d.id_articulo_manufacturado " +
                    "GROUP BY a.denominacion " +
                    "ORDER BY cantidad_productos_vendidos DESC",
            nativeQuery = true
    )
    List<DTORankingArticulosManufacturados> filtroPorProductoVendido();

    // Filtra por fecha los productos de mas vendidos a menos
    @Query(
            value = "SELECT a.denominacion, SUM(d.cantidad) AS cantidad_productos_vendidos FROM articulo_manufacturado a INNER JOIN detalle_factura d ON a.id = d.id_articulo_manufacturado INNER JOIN factura f ON d.id_factura = f.id WHERE f.fecha_facturacion BETWEEN :filtro1 AND :filtro2 " +
                    "GROUP BY a.denominacion " +
                    "ORDER BY cantidad_productos_vendidos DESC",
            nativeQuery = true
    )
    List<DTORankingArticulosManufacturados> filtradoPorProductoVendidoPorFecha(@Param("filtro1") Date filtro1, @Param("filtro2") Date filtro2);

}
