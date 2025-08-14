package com.caneksoft.peliculas.service.Impl;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caneksoft.peliculas.model.entity.Product;
import com.caneksoft.peliculas.persistence.IProductDAO;
import com.caneksoft.peliculas.service.IProductService;

@Service
public class ProductServiceImpl implements IProductService{

    @Autowired
    private IProductDAO productDAO;

    @Override
    public List<Product> findAll() {
       return productDAO.findAll();
    }

    @Override
    public List<Product> findByPriceInRange(BigDecimal minPrice, BigDecimal maxPrice) {
       return productDAO.findByPriceInRange(minPrice, maxPrice);
    }

    @Override
    public Optional<Product> findById(Long id) {
        return productDAO.findById(id);
    }

    @Override
    public void save(Product product) {
        productDAO.save(product);
    }

    @Override
    public void deleteById(Long id) {
        productDAO.deleteById(id);
    }

}
