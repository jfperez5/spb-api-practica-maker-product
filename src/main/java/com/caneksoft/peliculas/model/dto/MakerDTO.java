package com.caneksoft.peliculas.model.dto;

import java.util.ArrayList;
import java.util.List;

import com.caneksoft.peliculas.model.entity.Product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MakerDTO {
    private Long id;  
    private String name;
    private List<Product> productList = new ArrayList<>();
}
