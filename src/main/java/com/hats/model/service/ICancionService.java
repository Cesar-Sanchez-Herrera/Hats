package com.hats.model.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.hats.model.entity.Artista;
import com.hats.model.entity.Cancion;

public interface ICancionService {
	
	public List<Cancion> getAllCanciones();
	public Cancion getCancionById(Integer id);
	public Cancion addCancion(Cancion cancion);
	public Cancion updateCancion(Cancion cancion);
	public boolean deleteCancionById(Integer id);


}
