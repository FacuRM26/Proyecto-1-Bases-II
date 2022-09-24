package com.example.proyecto1.Controllers;

import com.example.proyecto1.Proyecto1Application;
import com.example.proyecto1.Services.JuegoService;
import com.example.proyecto1.Services.PersonajeService;
import com.example.proyecto1.models.Juego;
import com.example.proyecto1.models.Personaje;
import com.example.proyecto1.Repositories.PersonajeRepository;
import com.example.proyecto1.models.Raza;
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
    @Autowired
    private JuegoService juegoService;
    @Autowired
    private JuegoService razaService;

    public static void main(String[] args) {
        SpringApplication.run(Proyecto1Application.class, args);
    }

    /*Obtener todos los personajes*/
    @GetMapping("/personajes")
    public ModelAndView personajes(){
        List<Personaje> personajes = personajeService.obtenerPersonajes();
        ModelAndView mav = new ModelAndView(("MainView"));
        mav.addObject("personaje", personajes);
        return mav;
    }

    /*Crear un personaje*/
    @PostMapping("/guardarpersonaje")
    public String guardarPersonaje(@ModelAttribute Personaje personaje,@RequestParam String juegos){
        personajeService.guardarPersonaje(personaje);
        personajeService.addGames(personaje.getId(),juegos);
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

    @PostMapping("/fichapersonaje")
    public ModelAndView mostrarFicha(@RequestParam Integer id) throws Exception {
        ModelAndView mav = new ModelAndView(("individual/PersonajeView"));
        Personaje personaje = personajeService.buscarPersonaje(id);
        String juegos = personajeService.getJuegosById(id);
        System.out.println(juegos);
        mav.addObject("dato",personaje);
        mav.addObject("juego",juegos);
        return mav;
    }
}
