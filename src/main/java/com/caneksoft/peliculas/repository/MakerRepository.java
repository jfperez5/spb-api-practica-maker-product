package com.caneksoft.peliculas.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.caneksoft.peliculas.model.entity.Maker;


@Repository
public interface MakerRepository extends CrudRepository<Maker, Long> {

}
