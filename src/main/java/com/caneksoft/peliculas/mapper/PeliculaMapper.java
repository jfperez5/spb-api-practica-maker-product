package com.caneksoft.peliculas.mapper;

import org.mapstruct.Mapper;

import com.caneksoft.peliculas.model.dto.PeliculaDto;
import com.caneksoft.peliculas.model.entity.Pelicula;


@Mapper(componentModel = "spring")   
public interface PeliculaMapper {

    PeliculaDto toDto(Pelicula pelicula);
    
    Pelicula toEntity(PeliculaDto peliculaDto);
}

