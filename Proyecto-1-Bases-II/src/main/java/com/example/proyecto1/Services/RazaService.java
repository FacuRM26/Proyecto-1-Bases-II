package com.example.proyecto1.Services;


import com.example.proyecto1.Repositories.RazaRepository;
import com.example.proyecto1.models.Juego;
import com.example.proyecto1.models.Personaje;
import com.example.proyecto1.models.Raza;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class RazaService {
    @Autowired
    RazaRepository razaRepository;

    public ArrayList<Raza> obtenerRazas(){
        return (ArrayList<Raza>) razaRepository.findAll();
    }

    public Raza guardarRaza(Raza raza){
        return razaRepository.save(raza);
    }

    public void borrarRaza(int id){
        razaRepository.deleteById(id);
    }

    public Raza actualizarRaza(Raza raza){
        return razaRepository.save(raza);
    }

    public Raza buscarRaza(int id){
        return  razaRepository.getReferenceById(id);
    }
}
