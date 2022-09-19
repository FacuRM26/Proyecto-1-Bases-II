package com.example.proyecto1.Controllers;

import com.example.proyecto1.Proyecto1Application;
import com.example.proyecto1.Repositories.JuegoRepository;
import com.example.proyecto1.Repositories.PersonajeRepository;
import com.example.proyecto1.Repositories.RazaRepository;
import com.example.proyecto1.models.Juego;
import com.example.proyecto1.models.Personaje;
import com.example.proyecto1.models.Raza;
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
public class AdminController {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private PersonajeRepository personajeRepository;
    @Autowired
    private RazaRepository razaRepository;

    @Autowired
    private JuegoRepository juegoRepository;

    public static void main(String[] args) {
        SpringApplication.run(Proyecto1Application.class, args);
    }



    @GetMapping("/admin/personajes")
    public ModelAndView personajes(){
        List<Personaje> personajes = personajeRepository.findAll();
        List<Raza> razas = razaRepository.findAll();
        List<Juego> juegos = juegoRepository.findAll();
        ModelAndView mav = new ModelAndView(("adminPersonajes"));
        mav.addObject("item", personajes);
        mav.addObject("item2", razas);
        mav.addObject("item3",juegos);
        return mav;
    }

    @GetMapping("/admin/razas")
    public ModelAndView razas(){
        List<Raza> razas = razaRepository.findAll();
        List<Juego> juegos = juegoRepository.findAll();
        ModelAndView mav = new ModelAndView(("adminRazas"));
        mav.addObject("item", razas);
        mav.addObject("item2", juegos);
        return mav;
    }

    @GetMapping("/admin/juegos")
    public ModelAndView juegos(){
        List<Juego> juegos = juegoRepository.findAll();
        ModelAndView mav = new ModelAndView(("adminJuegos"));
        mav.addObject("item", juegos);
        return mav;
    }

}
