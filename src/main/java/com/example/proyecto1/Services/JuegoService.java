package com.example.proyecto1.Services;


import com.example.proyecto1.Repositories.JuegoRepository;
import com.example.proyecto1.models.Juego;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.sql.CallableStatement;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;

@Service
public class JuegoService {
    @Autowired
    JuegoRepository juegoRepository;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public ArrayList<Juego> obtenerJuegos(){
        return (ArrayList<Juego>) juegoRepository.findAll();
    }

    public Juego guardarJuego(Juego juego){
        return juegoRepository.save(juego);
    }

    public void borrarJuego(int id){
        juegoRepository.deleteById(id);
    }

    public Juego actualizarJuego(Juego juego){
        return juegoRepository.save(juego);
    }

    public Juego buscarJuego(int id){
        return  juegoRepository.getReferenceById(id);
    }


    public String getPersonajesById(int id) throws Exception {
        CallableStatement stmt= jdbcTemplate.getDataSource().getConnection().prepareCall("{?=call Fc_Consulta_Personajes_X_Juego(?)}");
        return getResultSet(stmt, id);
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
