package com.survivor.model.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.survivor.model.entity.Album;

public interface IAlbumService {
	
	public List<Album> findAll();
	public Page<Album> findAll(Pageable pageable);
	public Album findByID(Integer id);
	public Album save(Album alb);
	public void delete(Integer id);


}
