package com.utn.ElBuenSabor.repositories;

import com.utn.ElBuenSabor.entities.Usuario;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsuarioRepository extends BaseRepository<Usuario, Long> {

    Optional<Usuario> findByUsername(String username);

    @Query(
            value = "SELECT * FROM usuario WHERE usuario.username LIKE :username AND usuario.password LIKE :password",
            nativeQuery = true
    )
    List<Usuario> searchNativo(@Param("username") String username,@Param("password") String password);

    @Transactional
    @Modifying
    @Query(
            value = "UPDATE usuario SET password = :contrasenaNueva WHERE id = :id",
            nativeQuery = true
    )
    public int cambiarContrasena(@Param("id") Long id,
                                 @Param("contrasenaNueva") String contrasenaNueva);

}
