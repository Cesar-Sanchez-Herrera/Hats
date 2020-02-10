package com.hats.model.dao;

import org.springframework.data.repository.CrudRepository;

import com.hats.model.entity.UserArtista;

//Modelo CRUD de Usuarios Artistas//

public interface IUserArtistaDAO extends CrudRepository<UserArtista, Integer> {


	
}
