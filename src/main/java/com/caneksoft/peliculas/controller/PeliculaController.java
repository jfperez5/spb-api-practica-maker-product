package com.caneksoft.peliculas.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.caneksoft.peliculas.model.dto.PeliculaDto;
import com.caneksoft.peliculas.service.PeliculaService;

@RestController
@RequestMapping("/api/peliculas")
public class PeliculaController {

    private final PeliculaService peliculaService;

    public PeliculaController(PeliculaService peliculaService) {
        this.peliculaService = peliculaService;
    }

    @GetMapping
    public List<PeliculaDto> getAllMovies() {
        return peliculaService.getAllMovies();
    }
    
    @GetMapping("/{id}")
    public PeliculaDto getMovieById(@PathVariable Long id) {  
        return peliculaService.getMovieById(id);
    }
        
    @PostMapping
    public PeliculaDto saveMovie(@RequestBody PeliculaDto peliculaDto) {
        return peliculaService.saveMovie(peliculaDto);
    }

    @PutMapping("/{id}")
    public PeliculaDto updateMovie(@PathVariable Long id, @RequestBody PeliculaDto peliculaDto) {
        return peliculaService.updateMovie(id, peliculaDto);
    }
    
    @DeleteMapping("/{id}")
    public void deleteMovie(@PathVariable Long id) {
        peliculaService.deleteMovie(id);
    }

    
}      

        
