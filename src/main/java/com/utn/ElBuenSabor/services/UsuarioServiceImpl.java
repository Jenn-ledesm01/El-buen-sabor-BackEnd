package com.utn.ElBuenSabor.services;

import com.utn.ElBuenSabor.dtos.DTOCambiarContrasenia;
import com.utn.ElBuenSabor.entities.Usuario;
import com.utn.ElBuenSabor.repositories.BaseRepository;
import com.utn.ElBuenSabor.repositories.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImpl extends BaseServiceImpl<Usuario,Long> implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public UsuarioServiceImpl(BaseRepository<Usuario, Long> baseRepository, UsuarioRepository usuarioRepository) {
        super(baseRepository);
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public List<Usuario> search(String username, String password) throws Exception {
        try {
            List<Usuario> entities = usuarioRepository.searchNativo(username, password);
            return entities;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Optional<Usuario> findByUsername(String username) {
        try {
            Optional<Usuario> user = usuarioRepository.findByUsername(username);
            return user;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public boolean cambiarContrasena(DTOCambiarContrasenia dtoCambiarContrasenia) throws Exception{
        try{
            Usuario usuario = usuarioRepository.getReferenceById(dtoCambiarContrasenia.getId());
            if (usuario.getPassword().equals(dtoCambiarContrasenia.getContraseniaActual())) {
                usuarioRepository.cambiarContrasena(dtoCambiarContrasenia.getId(), dtoCambiarContrasenia.getContraseniaNueva());

                return true;
            }else{
                return false;
            }
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

}