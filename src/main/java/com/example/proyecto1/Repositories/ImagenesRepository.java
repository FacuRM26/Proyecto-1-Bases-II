package com.example.proyecto1.Repositories;

import com.example.proyecto1.models.Imagenes;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ImagenesRepository extends MongoRepository<Imagenes, Integer> {
}

