package com.caneksoft.peliculas.service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caneksoft.peliculas.model.entity.Maker;
import com.caneksoft.peliculas.persistence.IMakerDAO;
import com.caneksoft.peliculas.service.IMakerService;

@Service
public class MakerServiceImpl implements IMakerService  {

    @Autowired
    private IMakerDAO makerDAO;

    @Override
    public List<Maker> findAll() {
       return makerDAO.findAll();
    }

    @Override
    public Optional<Maker> findById(Long id) {
        return makerDAO.findById(id);
    }

    @Override
    public void save(Maker maker) {
        makerDAO.save(maker);    
    }

    @Override
    public void deleteById(Long id) {
       makerDAO.deleteById(id);
    }

}

// https://www.youtube.com/watch?v=cXvDDvX16RM
// 50:10