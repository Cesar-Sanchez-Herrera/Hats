package com.hats.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hats.model.dao.ICancionDAO;
import com.hats.model.dao.IPublicacionesDAO;
import com.hats.model.entity.Cancion;
import com.hats.model.entity.Publicaciones;

//Implementacion de servicio de Publicaciones//

@Service
public class PublicacionesServiceImpl implements IPublicacionesService {

	@Autowired
	private IPublicacionesDAO publicacionesDAO;

	//Obtener todas las publicaciones//
	@Override
	public List<Publicaciones> getAllPublicaciones() {
		return (List<Publicaciones>) publicacionesDAO.findAll();
	}

	//Obtener una publicacion por id//
	@Override
	public Publicaciones getPublicacionById(Integer id) {
		Publicaciones publicaciones = this.publicacionesDAO.findById(id).orElse(null);
		return publicaciones;
	}

	//Añadir una publicacion//
	@Override
	public Publicaciones addPublicacion(Publicaciones publicaciones) {
		return this.publicacionesDAO.save(publicaciones);
	}

	//Modificar una publicacion//
	@Override
	public Publicaciones updatePublicacion(Publicaciones publicaciones) {
		return publicacionesDAO.save(publicaciones);
	}

	//Borrar una publicacion//
	@Override
	public boolean deletePublicacionById(Integer id) {
		this.publicacionesDAO.deleteById(id);
		return true;
	}
	
	
}
