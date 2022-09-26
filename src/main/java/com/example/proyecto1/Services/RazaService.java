package com.example.proyecto1.Services;


import com.example.proyecto1.Repositories.RazaRepository;
import com.example.proyecto1.models.Juego;
import com.example.proyecto1.models.Personaje;
import com.example.proyecto1.models.Raza;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;

@Service
public class RazaService {
    @Autowired
    RazaRepository razaRepository;

    @Autowired
    private JdbcTemplate jdbcTemplate;


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

    public String getJuegosById(int id) throws Exception {
        CallableStatement stmt= jdbcTemplate.getDataSource().getConnection().prepareCall("{?=call Fc_Consulta_Juego_X_Raza(?)}");
        return getResultSet(stmt, id);
    }

    public String getPersonajesById(int id) throws Exception {
        CallableStatement stmt= jdbcTemplate.getDataSource().getConnection().prepareCall("{?=call Fc_Consulta_Personaje_X_Raza(?)}");
        return getResultSet(stmt, id);
    }

    public void addGames(int id,String juegos){
        String sql = "{call Pr_Raza_Juego(?,?)}";
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
