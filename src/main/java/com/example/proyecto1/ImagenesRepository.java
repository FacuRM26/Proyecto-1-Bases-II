package com.example.proyecto1;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface ImagenesRepository extends MongoRepository<Imagenes, Integer> {
}

