package com.example.proyecto1.Controllers;

import com.example.proyecto1.Proyecto1Application;
import com.example.proyecto1.Services.PersonajeService;
import com.example.proyecto1.models.Juego;
import com.example.proyecto1.models.Personaje;
import com.example.proyecto1.Repositories.PersonajeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.data.annotation.Id;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/")
public class PersonajesController {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    PersonajeService personajeService;

    public static void main(String[] args) {
        SpringApplication.run(Proyecto1Application.class, args);
    }

    /*Obtener todos los personajes*/
    @GetMapping("/personajes")
    public ModelAndView personajes(){
        List<Personaje> personajes = personajeService.obtenerPersonajes();
        ModelAndView mav = new ModelAndView(("MainView"));
        mav.addObject("item", personajes);
        return mav;
    }

    /*Crear un personaje*/
    @PostMapping("/guardarpersonaje")
    public String guardarPersonaje(@ModelAttribute Personaje personaje){
        personajeService.guardarPersonaje(personaje);
        return "redirect:admin/personajes";
    }

    /*Ver ficha de personaje*/
    @GetMapping("/personaje")
    public ModelAndView personaje(){
        ModelAndView mav = new ModelAndView(("individual/PersonajeView"));
        return mav;
    }

    @PostMapping("/eliminarpersonaje")
    public String eliminarPersonaje(@RequestParam Integer id){
        personajeService.borrarPersonaje(id);
        return "redirect:admin/personajes";
    }

    @PostMapping("/actualizarpersonaje")
    public String actualizarPersonaje(@ModelAttribute Personaje personaje){
        personajeService.actualizarPersonaje(personaje);
        return "redirect:admin/personajes";
    }
}
