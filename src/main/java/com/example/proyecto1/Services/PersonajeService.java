package com.example.proyecto1.Services;


import com.example.proyecto1.Repositories.PersonajeRepository;
import com.example.proyecto1.models.Juego;
import com.example.proyecto1.models.Personaje;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

@Service
public class PersonajeService {
    @Autowired
    PersonajeRepository personajeRepository;
    @Autowired
    private JdbcTemplate jdbcTemplate;

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

    public String getJuegosById(int id) throws Exception {
        CallableStatement stmt= jdbcTemplate.getDataSource().getConnection().prepareCall("{?=call Fc_Consulta_Juego_X_Personaje(?)}");
        return getResultSet(stmt, id);
    }

    public void addGames(int id,String juegos){
        String sql = "{call Pr_Personaje_Juego(?,?)}";
        jdbcTemplate.update(sql, id, juegos);
    }


    private String getResultSet(CallableStatement stmt, int Id ) throws Exception{
        stmt.registerOutParameter(1, Types.REF_CURSOR);
        stmt.setInt(2, Id);
        stmt.execute();
        ResultSet cursor = stmt.getObject(1, ResultSet.class);
        String result = "";
        while (cursor.next()) {
            result = result + cursor.getString("nombre") + ", ";
        }
        return result;
    }
}
