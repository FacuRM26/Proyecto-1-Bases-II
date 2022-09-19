package com.example.proyecto1.Services;


import com.example.proyecto1.Repositories.JuegoRepository;
import com.example.proyecto1.models.Juego;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.ArrayList;

@Service
public class JuegoService {
    @Autowired
    JuegoRepository juegoRepository;

    public ArrayList<Juego> obtenerJuegos(){
        return (ArrayList<Juego>) juegoRepository.findAll();
    }

    public Juego guardarJuego(Juego juego){
        return juegoRepository.save(juego);
    }

    public void borrarJuego(int id){
        juegoRepository.deleteById(id);
    }

}
