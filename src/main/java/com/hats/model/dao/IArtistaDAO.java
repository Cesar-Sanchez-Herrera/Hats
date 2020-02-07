package com.hats.model.dao;


import org.springframework.data.repository.CrudRepository;

import com.hats.model.entity.Artista;

public interface IArtistaDAO extends CrudRepository<Artista, Integer> {
	
}
