package com.survivor.model.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.survivor.model.entity.Artista;

public interface IArtistaService {
	
	public List<Artista> findAll();
	public Page<Artista> findAll(Pageable pageable);
	public Artista findByID(Integer id);
	public Artista save(Artista art);
	public void delete(Integer id);


}
