package com.hats.model.dao;


import org.springframework.data.repository.CrudRepository;

import com.hats.model.entity.Cancion;

public interface ICancionDAO extends CrudRepository<Cancion, Integer> {


	
}
