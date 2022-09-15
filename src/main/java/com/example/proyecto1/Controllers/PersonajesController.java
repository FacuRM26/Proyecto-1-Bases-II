package com.example.proyecto1.Controllers;

import com.example.proyecto1.Proyecto1Application;
import com.example.proyecto1.models.Personaje;
import com.example.proyecto1.Repositories.PersonajeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/")
public class PersonajesController {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private PersonajeRepository personajeRepository;
    public static void main(String[] args) {
        SpringApplication.run(Proyecto1Application.class, args);
    }

    @GetMapping("/personajes")
    public ModelAndView personajes(){
        List<Personaje> personajes = personajeRepository.findAll();
        personajes.forEach(System.out::println);
        ModelAndView mav = new ModelAndView(("MainView"));
        mav.addObject("item", personajes);
        return mav;
    }

    @GetMapping("/personaje")
    public ModelAndView personaje(){
        ModelAndView mav = new ModelAndView(("PersonajeView"));
        return mav;
    }
}
