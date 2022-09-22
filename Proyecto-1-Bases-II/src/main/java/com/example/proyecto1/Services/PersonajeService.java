package com.example.proyecto1.Services;


import com.example.proyecto1.Repositories.PersonajeRepository;
import com.example.proyecto1.models.Juego;
import com.example.proyecto1.models.Personaje;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class PersonajeService {
    @Autowired
    PersonajeRepository personajeRepository;

    public ArrayList<Personaje> obtenerPersonajes(){
        return (ArrayList<Personaje>) personajeRepository.findAll();
    }

    public Personaje guardarPersonaje(Personaje personaje){
        return personajeRepository.save(personaje);
    }

    public void borrarPersonaje(int id){
        personajeRepository.deleteById(id);
    }

    public Personaje actualizarPersonaje(Personaje personaje){
        return personajeRepository.save(personaje);
    }

    public Personaje buscarPersonaje(int id){
        return  personajeRepository.getReferenceById(id);
    }
}
