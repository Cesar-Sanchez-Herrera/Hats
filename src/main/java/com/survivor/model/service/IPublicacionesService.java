package com.survivor.model.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.survivor.model.entity.Publicaciones;

public interface IPublicacionesService {
	
	public List<Publicaciones> findAll();
	public Page<Publicaciones> findAll(Pageable pageable);
	public Publicaciones findByID(Integer id);
	public Publicaciones save(Publicaciones publi);
	public void delete(Integer id);


}
