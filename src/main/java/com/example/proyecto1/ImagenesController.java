package com.example.proyecto1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ImagenesController {
    @Autowired
    private ImagenesRepository imagenesRepository;
    @PostMapping("/addImagenes")
    public String saveImagenes(@RequestBody Imagenes imagenes) {
        imagenesRepository.save(imagenes);
        return "Added imagenes with id : " + imagenes.getId();
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
