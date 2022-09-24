package com.example.proyecto1;

import com.example.proyecto1.Repositories.JuegoRepository;
import com.example.proyecto1.Repositories.PersonajeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.Types;

@SpringBootApplication
public class Proyecto1Application implements CommandLineRunner {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private PersonajeRepository personajeRepository;
    @Autowired
    private JuegoRepository juegoRepository;

    public static void main(String[] args) {
        SpringApplication.run(Proyecto1Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {


//Obtener todos los personajes que pertenecen al juego con ese ID
//        CallableStatement stmt= jdbcTemplate.getDataSource().getConnection().prepareCall("{?=call Fc_Consulta_Personajes_X_Juego(?)}");
//        stmt.registerOutParameter(1,Types.REF_CURSOR);
//        stmt.setInt(2, 4);
//        stmt.execute();
//        ResultSet cursor = stmt.getObject(1, ResultSet.class);
//        String personajes="";
//        while(cursor.next()) {
//            personajes = personajes + cursor.getString("nombre")+", ";
//            System.out.println("Id_Personaje = " + cursor.getString(1));
//        }

////Obtener todos los personajes que pertenecen al juego con ese ID
//        CallableStatement stmt= jdbcTemplate.getDataSource().getConnection().prepareCall("{?=call Fc_Consulta_Personajes_X_Juego(?)}");
//        String result =getResultSet(stmt, 3);
//        System.out.println(result.substring(0,result.length()-2));

//        //Obtener todos los personajes que pertenecen a la raza con ese ID
//        stmt= jdbcTemplate.getDataSource().getConnection().prepareCall("{?=call Fc_Consulta_Personaje_X_Raza(?)}");
//        result =getResultSet(stmt, 1);
//        System.out.println(result.substring(0,result.length()-2));
//
//        //Obtener todos los juegos que pertenecen al personaje con ese ID
//        stmt= jdbcTemplate.getDataSource().getConnection().prepareCall("{?=call Fc_Consulta_Juego_X_Personaje(?)}");
//        result =getResultSet(stmt, 2);
//        System.out.println(result.substring(0,result.length()-2));

        //Obtener todos los juegos que pertenecen a la raza con ese ID
//        stmt= jdbcTemplate.getDataSource().getConnection().prepareCall("{?=call Fc_Consulta_Juego_X_Raza(?)}");
//        result =getResultSet(stmt, 2);
//        System.out.println(result.substring(0,result.length()-2));

//        //Obtener todas las razas que pertenecen al juego con ese id
//        stmt= jdbcTemplate.getDataSource().getConnection().prepareCall("{?=call Fc_Consulta_Raza_X_Juego(?)}");
//        result =getResultSet(stmt, 2);
//        System.out.println(result.substring(0,result.length()-2));

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
