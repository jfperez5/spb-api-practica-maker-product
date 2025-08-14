package com.caneksoft.peliculas.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import com.caneksoft.peliculas.model.entity.Product;

public interface IProductService {
    List<Product> findAll();

    List<Product> findByPriceInRange(BigDecimal minPrice, BigDecimal maxPrice);
    
    Optional <Product> findById(Long id);

    void save(Product product);
    
    void deleteById(Long id);
}
