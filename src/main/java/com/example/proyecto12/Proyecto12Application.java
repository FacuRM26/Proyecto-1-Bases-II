package com.example.proyecto12;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

@SpringBootApplication
public class Proyecto12Application implements CommandLineRunner {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private StudentRepository studentRepository;
    public static void main(String[] args) {
        SpringApplication.run(Proyecto12Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        //String sql = "SELECT * FROM Students";
        //List<Student> students = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Student.class));
        //students.forEach(System.out::println);
        List<Student> students = studentRepository.findAll();
        students.forEach(System.out::println);
    }
}
