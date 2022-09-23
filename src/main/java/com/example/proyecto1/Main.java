package com.example.proyecto1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;



@SpringBootApplication
public class Main implements CommandLineRunner {
    @Autowired
     private JdbcTemplate jdbcTemplate;
    @Autowired
    //private StudentRepository studentRepository;
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
    @Override
    public void run(String... args) throws Exception {

        String sql = "SELECT * FROM Personaje";
        List<Personaje> personaje = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Personaje.class));
        personaje.forEach(System.out::println);
//
//        String sql2 = "SELECT * FROM Raza";
//        List<Raza> raza = jdbcTemplate.query(sql2, BeanPropertyRowMapper.newInstance(Raza.class));
//        raza.forEach(System.out::println);
//
//        String sql3 = "SELECT * FROM Juego";
//        List<Juego> juego = jdbcTemplate.query(sql3, BeanPropertyRowMapper.newInstance(Juego.class));
//        juego.forEach(System.out::println);


//        String sql4 = "INSERT INTO Personaje (nombre,genero,ciudad_residencia,familia,enemigo,raza_id) VALUES ('Zelda','Femenino','Hyrule','Familia Real de Hyrule',0,4)";
//        jdbcTemplate.update(sql4);
//
//        //insertar en tabla raza enviado datos
//        String sql5 = "INSERT INTO Raza (nombre,habitat,etimologia) VALUES (?, ?, ?)";
//        jdbcTemplate.update(sql5, "Zora", "Lago de Hylia", "El nombre de Zora puede que provenga del pescado llamado rémora.");

        //insertar en tabla juego enviando datos
//        String sql6 = "INSERT INTO Juego (nombre,consolas,fecha_publicacion,linea_cronologica) VALUES (?, ?, ?, ?)";
//        jdbcTemplate.update(sql6, "The Legend of Zelda: Breath of the Wild", "Nintendo Switch", "03/03/2017", "Descocnocida");


//        //eliminar en tabla juego enviando datos
//        String sql7 = "DELETE FROM Personaje WHERE id = ?";
//        jdbcTemplate.update(sql7, 24);
//        System.out.println("Elimanado correctamente");
//
//        //actualizar en tabla personaje enviando datos
//        String sql8 = "UPDATE Personaje SET nombre = ? WHERE id = ?";
//        jdbcTemplate.update(sql8, "Princesa Zelda", 23);


        //Obtener todos los personajes que pertenecen al juego con ese ID
//        CallableStatement stmt= jdbcTemplate.getDataSource().getConnection().prepareCall("{?=call Fc_Consulta_Personajes_X_Juego(?)}");
//        String result =getResultSet(stmt, 4);
//        System.out.println(result.substring(0,result.length()-2));
//
//        //Obtener todos los personajes que pertenecen a la raza con ese ID
//        stmt= jdbcTemplate.getDataSource().getConnection().prepareCall("{?=call Fc_Consulta_Personaje_X_Raza(?)}");
//        result =getResultSet(stmt, 4);
//        System.out.println(result.substring(0,result.length()-2));
//
//        //Obtener todos los juegos que pertenecen al personaje con ese ID
//        stmt= jdbcTemplate.getDataSource().getConnection().prepareCall("{?=call Fc_Consulta_Juego_X_Personaje(?)}");
//        result =getResultSet(stmt, 23);
//        System.out.println(result.substring(0,result.length()-2));
//
//        //Obtener todos los juegos que pertenecen a la raza con ese ID
//        stmt= jdbcTemplate.getDataSource().getConnection().prepareCall("{?=call Fc_Consulta_Juego_X_Raza(?)}");
//        result =getResultSet(stmt, 4);
//        System.out.println(result.substring(0,result.length()-2));
//
//        //Obtener todas las razas que pertenecen al juego con ese id
//        stmt= jdbcTemplate.getDataSource().getConnection().prepareCall("{?=call Fc_Consulta_Raza_X_Juego(?)}");
//        result =getResultSet(stmt, 2);
//        System.out.println(result.substring(0,result.length()-2));
        //Procedimiento almacenado
        //llamar procedimiento almacenado que recibe un id y un string
        String sql8 = "{call Pr_Personaje_Juego(?,?)}";
        jdbcTemplate.update(sql8, 53, "The Legend of Zelda: The Minish Cap");
        sql8="{call Pr_Juego_Raza(?,?)}";
        jdbcTemplate.update(sql8, 21, "Zora,Goron,Hyliano");
        sql8="{call Pr_Juego_Personaje(?,?)}";
        jdbcTemplate.update(sql8, 22, "Ezero");
    }


    private String getResultSet(CallableStatement stmt,int Id ) throws Exception{
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
