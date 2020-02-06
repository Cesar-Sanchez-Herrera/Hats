package com.survivor.model.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import com.survivor.model.entity.Album;

public interface IAlbumDAO extends JpaRepository<Album, Integer> {

	
}
