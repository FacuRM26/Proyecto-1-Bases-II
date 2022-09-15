package com.example.proyecto1.Controllers;

import com.example.proyecto1.Proyecto1Application;
import com.example.proyecto1.Repositories.JuegoRepository;
import com.example.proyecto1.models.Juego;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/")
public class JuegoController {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private JuegoRepository juegoRepository;
    public static void main(String[] args) {
        SpringApplication.run(Proyecto1Application.class, args);
    }

    @GetMapping("/juegos")
    public ModelAndView juegos(){
        List<Juego> juegos = juegoRepository.findAll();
        juegos.forEach(System.out::println);
        ModelAndView mav = new ModelAndView(("MainView"));
        mav.addObject("item", juegos);
        return mav;
    }
}
