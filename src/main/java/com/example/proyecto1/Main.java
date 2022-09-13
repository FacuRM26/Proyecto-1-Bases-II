package com.example.proyecto1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

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

        String sql2 = "SELECT * FROM Raza";
        List<Raza> raza = jdbcTemplate.query(sql2, BeanPropertyRowMapper.newInstance(Raza.class));
        raza.forEach(System.out::println);

        String sql3 = "SELECT * FROM Juego";
        List<Juego> juego = jdbcTemplate.query(sql3, BeanPropertyRowMapper.newInstance(Juego.class));
        juego.forEach(System.out::println);


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
    }
}
