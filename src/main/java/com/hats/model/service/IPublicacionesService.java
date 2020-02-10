package com.hats.model.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.hats.model.entity.Cancion;
import com.hats.model.entity.Publicaciones;

//Servicio de Publicaciones//

public interface IPublicacionesService {
	
	public List<Publicaciones> getAllPublicaciones();
	public Publicaciones getPublicacionById(Integer id);
	public Publicaciones addPublicacion(Publicaciones publicaciones);
	public Publicaciones updatePublicacion(Publicaciones publicaciones);
	public boolean deletePublicacionById(Integer id);


}
