package com.caneksoft.peliculas.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class PeliculaDto {
    private Long id;
    private String titulo;
    private String director;
    private String anio;
    private String genero;
    private String duracion;
    private String sinopsis;    
    private String reparto;
    private String idioma;
    private String estatus;
    
}
