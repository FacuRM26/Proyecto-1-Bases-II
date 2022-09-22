package com.example.proyecto1.Controllers;

import com.example.proyecto1.Proyecto1Application;
import com.example.proyecto1.Repositories.RazaRepository;
import com.example.proyecto1.Services.PersonajeService;
import com.example.proyecto1.Services.RazaService;
import com.example.proyecto1.models.Juego;
import com.example.proyecto1.models.Raza;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/")
public class RazaController {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    RazaService razaService;
    public static void main(String[] args) {
        SpringApplication.run(Proyecto1Application.class, args);
    }

    @GetMapping("/razas")
    public ModelAndView razas(){
        List<Raza> razas = razaService.obtenerRazas();
        razas.forEach(System.out::println);
        ModelAndView mav = new ModelAndView(("MainView"));
        mav.addObject("item", razas);
        return mav;
    }

    /*Ver ficha de Raza*/
    @GetMapping("/raza")
    public ModelAndView personaje(){
        ModelAndView mav = new ModelAndView(("individual/RazaView"));
        return mav;
    }

    /*Crear una raza*/
    @PostMapping("/guardarraza")
    public String guardarRaza(@ModelAttribute Raza raza){
        razaService.guardarRaza(raza);
        return "redirect:admin/razas";
    }

    @PostMapping("/eliminarraza")
    public String eliminarPersonaje(@RequestParam Integer id){
        razaService.borrarRaza(id);
        return "redirect:admin/razas";
    }

    @PostMapping("/actualizarraza")
    public String actualizarRaza(@ModelAttribute Raza raza){
        razaService.actualizarRaza(raza);
        return "redirect:admin/razas";
    }
}
