package com.hats.model.dao;

import org.springframework.data.repository.CrudRepository;

//Modelo CRUD de Album//

import com.hats.model.entity.Album;

//Modelo CRUD de Album//

public interface IAlbumDAO extends CrudRepository<Album, Integer> {

	
}
