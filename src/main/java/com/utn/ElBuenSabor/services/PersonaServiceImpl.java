package com.utn.ElBuenSabor.services;

import com.utn.ElBuenSabor.dtos.DTOCambiarDatos;
import com.utn.ElBuenSabor.dtos.DTOPersona;
import com.utn.ElBuenSabor.dtos.DTOPersonaClientes;
import com.utn.ElBuenSabor.dtos.DTORankingPersonas;
import com.utn.ElBuenSabor.entities.Persona;
import com.utn.ElBuenSabor.repositories.BaseRepository;
import com.utn.ElBuenSabor.repositories.PersonaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

@Service
public class PersonaServiceImpl extends BaseServiceImpl<Persona,Long> implements PersonaService {

    @Autowired
    private PersonaRepository personaRepository;

    public PersonaServiceImpl(BaseRepository<Persona, Long> baseRepository, PersonaRepository PersonaRepository) {
        super(baseRepository);
        this.personaRepository = personaRepository;
    }

    @Override
    public List<Persona> search(String filtro) throws Exception {
        try{
            List<Persona> persona = personaRepository.searchNativo(filtro);
            return persona;
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Page<Persona> search(String filtro, Pageable pageable) throws Exception {
        try{
            Page<Persona> cliente = personaRepository.searchNativo(filtro, pageable);
            return cliente;
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }


    @Override
    public Persona cambiarDatos(DTOCambiarDatos dtoCambiarDatos) throws Exception{
        try{
            Persona persona = personaRepository.findById(dtoCambiarDatos.getId()).get();

            persona.setEmail(dtoCambiarDatos.getEmail());
            persona.setApellido(dtoCambiarDatos.getApellido());
            persona.setNombre(dtoCambiarDatos.getNombre());
            persona.setTelefono(dtoCambiarDatos.getTelefono());

            personaRepository.save(persona);

            return persona;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public List<DTOPersonaClientes> findClientes() throws Exception {
        try {
            List<DTOPersonaClientes> clientes = personaRepository.findClientes();
            return clientes;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public List<Persona> findEmpleados() throws Exception {
        try {
            return personaRepository.findEmpleados();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public List<DTORankingPersonas> rankingPersonas(@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date desde, @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date hasta) throws Exception{
        try{
            List<DTORankingPersonas> personas = personaRepository.rankingPersonas(desde,hasta);
            return personas;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}