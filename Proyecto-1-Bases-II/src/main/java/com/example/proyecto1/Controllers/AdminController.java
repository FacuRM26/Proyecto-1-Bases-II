package com.example.proyecto1.Controllers;

import com.example.proyecto1.Proyecto1Application;
import com.example.proyecto1.Repositories.JuegoRepository;
import com.example.proyecto1.Repositories.PersonajeRepository;
import com.example.proyecto1.Repositories.RazaRepository;
import com.example.proyecto1.Services.JuegoService;
import com.example.proyecto1.Services.PersonajeService;
import com.example.proyecto1.Services.RazaService;
import com.example.proyecto1.models.Juego;
import com.example.proyecto1.models.Personaje;
import com.example.proyecto1.models.Raza;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    private JuegoService juegoService;
    @Autowired
    private JuegoRepository juegoRepository;
    @Autowired
    RazaService razaService;
    @Autowired
    PersonajeService personajeService;


    public static void main(String[] args) {
        SpringApplication.run(Proyecto1Application.class, args);
    }


    //Pantallas para administrar tablas

    @GetMapping("/admin/personajes")
    public ModelAndView personajes(){
        List<Personaje> personajes = personajeRepository.findAll();
        List<Raza> razas = razaRepository.findAll();
        List<Juego> juegos = juegoRepository.findAll();
        ModelAndView mav = new ModelAndView(("admins/adminPersonajes"));
        mav.addObject("item", personajes);
        mav.addObject("item2", razas);
        mav.addObject("item3",juegos);
        return mav;
    }

    @GetMapping("/admin/razas")
    public ModelAndView razas(){
        List<Raza> razas = razaRepository.findAll();
        List<Juego> juegos = juegoRepository.findAll();
        ModelAndView mav = new ModelAndView(("admins/adminRazas"));
        mav.addObject("item", razas);
        mav.addObject("item2", juegos);
        return mav;
    }

    @GetMapping("/admin/juegos")
    public ModelAndView juegos(){
        List<Juego> juegos = juegoRepository.findAll();
        ModelAndView mav = new ModelAndView(("admins/adminJuegos"));
        mav.addObject("item", juegos);
        return mav;
    }

    //Pestañas para actualizar registros

    @PostMapping("/modificarjuego")
    public ModelAndView modificarJuego(@RequestParam Integer id){
        Juego juego = juegoService.buscarJuego(id);
        ModelAndView mav = new ModelAndView(("updates/updateJuego"));
        mav.addObject("dato",juego);
        return mav;
    }

    @PostMapping("/modificarraza")
    public ModelAndView modificarRaza(@RequestParam Integer id){
        Raza raza = razaService.buscarRaza(id);
        List<Juego> juegos = juegoRepository.findAll();
        ModelAndView mav = new ModelAndView(("updates/updateRaza"));
        mav.addObject("dato",raza);
        mav.addObject("juegos", juegos);
        return mav;
    }

    @PostMapping("/modificarpersonaje")
    public ModelAndView modificarPersonaje(@RequestParam Integer id){
        Personaje personaje = personajeService.buscarPersonaje(id);
        List<Raza> razas = razaRepository.findAll();
        List<Juego> juegos = juegoRepository.findAll();
        ModelAndView mav = new ModelAndView(("updates/updatePersonaje"));
        mav.addObject("dato",personaje);
        mav.addObject("raza",razas);
        mav.addObject("juego",juegos);
        return mav;
    }

}
