package com.caneksoft.peliculas.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.caneksoft.peliculas.model.dto.MakerDTO;
import com.caneksoft.peliculas.model.entity.Maker;
import com.caneksoft.peliculas.service.IMakerService;

@RestController
@RequestMapping("/api/makers")   
public class MakerController {

    @Autowired
    private IMakerService makerService;

    @GetMapping("/{id}")
    public ResponseEntity<?>findById(@PathVariable Long id) {
        Optional<Maker> makerOptional = makerService.findById(id);

        if (makerOptional.isPresent()) {
            Maker maker = makerOptional.get();

            MakerDTO makerDTO = MakerDTO.builder()
                .id(maker.getId())
                .name(maker.getName())
                .build();
            return ResponseEntity.ok(makerDTO);
        } 
        
        return ResponseEntity.notFound().build();
                
    }

    @GetMapping
    public List<MakerDTO> findAll() {
        List<Maker> makers = makerService.findAll();
        return makers.stream()
            .map(maker -> MakerDTO.builder()
                .id(maker.getId())
                .name(maker.getName())
                .build())
            .toList();
    }

}
