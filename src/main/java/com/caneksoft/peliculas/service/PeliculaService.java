package com.caneksoft.peliculas.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.caneksoft.peliculas.mapper.PeliculaMapper;
import com.caneksoft.peliculas.model.dto.PeliculaDto;
import com.caneksoft.peliculas.repository.PeliculaRepository;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@AllArgsConstructor
@Slf4j //Para crear logs que permitan el seguimiento de la ejecución del servicio.
public class PeliculaService {

    private final PeliculaRepository peliculaRepository;
    private final PeliculaMapper peliculaMapper;


    public List<PeliculaDto> getAllMovies() {
        log.info("Obteniendo todas las películas");
        return peliculaRepository.findAll().stream()
                .map(peliculaMapper::toDto)
                .toList();
    }

    public PeliculaDto getMovieById(Long id) {
        log.info("Obteniendo película con ID: {}", id);
        return peliculaRepository.findById(id)
                .map(peliculaMapper::toDto)
                .orElse(null); // O lanzar una excepción personalizada
    }


    public PeliculaDto saveMovie(PeliculaDto peliculaDto) {
        // log.info("Guardando película: {}", peliculaDto.getTitulo());
        var pelicula = peliculaMapper.toEntity(peliculaDto);
        return peliculaMapper.toDto(peliculaRepository.save(pelicula));
    }

    public PeliculaDto updateMovie(Long id, PeliculaDto peliculaDto) {
        log.info("Actualizando película con ID: {}", id);
        if (!peliculaRepository.existsById(id)) {
            return null; // O lanzar una excepción personalizada
        }
        peliculaDto.setId(id);
        var pelicula = peliculaMapper.toEntity(peliculaDto);
        return peliculaMapper.toDto(peliculaRepository.save(pelicula));
    }

    public void deleteMovie(Long id) {
        log.info("Eliminando película con ID: {}", id); 
        if (peliculaRepository.existsById(id)) {
            peliculaRepository.deleteById(id);
        } else {
            log.warn("No se encontró la película con ID: {}", id);
            // O lanzar una excepción personalizada
        }   
    }

}
