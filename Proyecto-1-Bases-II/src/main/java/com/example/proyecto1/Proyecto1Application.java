package com.example.proyecto1;

import com.example.proyecto1.Repositories.JuegoRepository;
import com.example.proyecto1.Repositories.PersonajeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

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

    }
}
