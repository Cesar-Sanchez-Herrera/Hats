package com.survivor.model.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.survivor.model.entity.Cancion;

public interface ICancionService {
	
	public List<Cancion> findAll();
	public Page<Cancion> findAll(Pageable pageable);
	public Cancion findByID(Integer id);
	public Cancion save(Cancion can);
	public void delete(Integer id);


}
