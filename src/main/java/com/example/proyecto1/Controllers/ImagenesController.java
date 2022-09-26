package com.example.proyecto1.Controllers;

import com.example.proyecto1.models.Imagenes;
import com.example.proyecto1.Repositories.ImagenesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ImagenesController {
    @Autowired
    private ImagenesRepository imagenesRepository;
    @PostMapping("/addImagenes")
    public String saveImagenes(@RequestParam String localizacion) {
        Imagenes img = new Imagenes(localizacion);
        imagenesRepository.save(img);
        return "Added imagenes with id : " ;
    }
    @GetMapping("/findAllImagenes")
    public List<Imagenes> getImagenes() {
        return imagenesRepository.findAll();
    }
    @GetMapping("/findAllImagenes/{id}")
    public Optional<Imagenes> getImagenes(@PathVariable int id) {
        return imagenesRepository.findById(id);
    }
    @DeleteMapping("/delete/{id}")
    public String deleteImagenes(@PathVariable int id) {
        imagenesRepository.deleteById(id);
        return "Imagenes removed !! " + id;
    }

}
