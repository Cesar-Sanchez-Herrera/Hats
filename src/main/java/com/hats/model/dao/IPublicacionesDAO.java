package com.hats.model.dao;

import org.springframework.data.repository.CrudRepository;

import com.hats.model.entity.Publicaciones;

//Modelo CRUD de Publicaciones//

public interface IPublicacionesDAO extends CrudRepository<Publicaciones, Integer> {


	
}
