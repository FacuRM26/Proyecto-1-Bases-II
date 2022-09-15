package com.example.proyecto1.Repositories;

import com.example.proyecto1.models.Personaje;
import com.example.proyecto1.models.Raza;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RazaRepository extends JpaRepository<Raza, Integer> {

}

