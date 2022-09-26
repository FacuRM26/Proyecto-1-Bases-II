package com.example.proyecto1.Controllers;

import com.example.proyecto1.Proyecto1Application;
import com.example.proyecto1.Services.JuegoService;
import com.example.proyecto1.models.Juego;
import com.example.proyecto1.models.Personaje;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/")
public class JuegoController {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private JuegoService juegoService;
    public static void main(String[] args) {
        SpringApplication.run(Proyecto1Application.class, args);
    }

    @GetMapping("/juegos")
    public ModelAndView juego(){
        List<Juego> juegos = juegoService.obtenerJuegos();
        ModelAndView mav = new ModelAndView(("MainView"));
        mav.addObject("juego", juegos);
        return mav;
    }

    /*Ver ficha de Juego*/
    @GetMapping("/juego")
    public ModelAndView personaje(){
        ModelAndView mav = new ModelAndView(("individual/JuegoView"));
        return mav;
    }

    /*Crear un personaje*/
    @PostMapping("/guardarjuego")
    public String guardarJuego(@ModelAttribute Juego juego){
        juegoService.guardarJuego(juego);
        return "redirect:admin/juegos";
    }

    @PostMapping("/eliminarjuego")
    public String eliminarJuego(@RequestParam Integer id){
        juegoService.borrarJuego(id);
        return "redirect:admin/juegos";
    }

    @PostMapping("/actualizarjuego")
    public String actualizarJuego(@ModelAttribute Juego juego){
        juegoService.actualizarJuego(juego);
        return "redirect:admin/juegos";
    }

    @PostMapping("/fichajuego")
    public ModelAndView mostrarFicha(@RequestParam Integer id) throws Exception {
        ModelAndView mav = new ModelAndView(("individual/JuegoView"));
        Juego juego = juegoService.buscarJuego(id);
        String personajes = juegoService.getPersonajesById(id);
        mav.addObject("dato",juego);
        mav.addObject("personajes",personajes);
        return mav;
    }

}
