package com.caneksoft.peliculas.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
// Otra forma de listar los fabricantes
    @GetMapping("/findAll")
    public ResponseEntity<?> buscarTodos(){
        List<MakerDTO> makerList = makerService.findAll()
        .stream()
        .map(maker ->MakerDTO.builder()
        .id(maker.getId())
        .name(maker.getName())
        .build())
        .toList();
        return ResponseEntity.ok(makerList);
    }

    @PostMapping("/save")
    public ResponseEntity<?>save(@RequestBody MakerDTO makerDTO) throws URISyntaxException{
        if(makerDTO.getName().isBlank()){
            return ResponseEntity.badRequest().build();
        }
        makerService.save(Maker.builder()
            .name(makerDTO.getName())
            .build()
        );
        return ResponseEntity.created(new URI("/api/maker/save")).build();
    }
    

    @PutMapping("/update/{id}")
    public ResponseEntity<?>updateMaker(@PathVariable Long id, @RequestBody MakerDTO makerDTO){
        Optional<Maker>makerOptional = makerService.findById(id);

        if(makerOptional.isPresent()){
            Maker maker =makerOptional.get();
            maker.setName(makerDTO.getName());
            makerService.save(maker);
            return ResponseEntity.ok("Registro actualizado");
        }

        return ResponseEntity.notFound().build();
    }
}


// https://www.youtube.com/watch?v=cXvDDvX16RM
// 1:02:57