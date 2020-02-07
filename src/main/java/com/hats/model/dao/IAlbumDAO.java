package com.hats.model.dao;



import org.springframework.data.repository.CrudRepository;

import com.hats.model.entity.Album;

public interface IAlbumDAO extends CrudRepository<Album, Integer> {

	
}
