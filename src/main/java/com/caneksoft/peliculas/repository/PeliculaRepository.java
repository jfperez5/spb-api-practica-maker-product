package com.caneksoft.peliculas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.caneksoft.peliculas.model.entity.Pelicula;

public interface PeliculaRepository extends JpaRepository<Pelicula, Long> {
    // Aquí puedes agregar métodos personalizados si es necesario

    
}
