package com.example.proyecto1.Controllers;

import com.example.proyecto1.Proyecto1Application;
import com.example.proyecto1.Repositories.RazaRepository;
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
public class RazaController {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private RazaRepository razaRepository;
    public static void main(String[] args) {
        SpringApplication.run(Proyecto1Application.class, args);
    }

    @GetMapping("/razas")
    public ModelAndView razas(){
        List<Raza> razas = razaRepository.findAll();
        razas.forEach(System.out::println);
        ModelAndView mav = new ModelAndView(("MainView"));
        mav.addObject("item", razas);
        return mav;
    }
}
