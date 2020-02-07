package com.hats.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hats.model.dao.ICancionDAO;
import com.hats.model.entity.Artista;
import com.hats.model.entity.Cancion;
import com.hats.model.entity.Publicaciones;

@Service
public class CancionServiceImpl implements ICancionService {

	@Autowired
	private ICancionDAO cancionDAO;

	@Override
	public List<Cancion> getAllCanciones() {
		return (List<Cancion>) cancionDAO.findAll();
	}

	@Override
	public Cancion getCancionById(Integer id) {
		Cancion cancion = this.cancionDAO.findById(id).orElse(null);
		return cancion;
	}

	@Override
	public Cancion addCancion(Cancion cancion) {
		return this.cancionDAO.save(cancion);
	}

	@Override
	public Cancion updateCancion(Cancion cancion) {
		return cancionDAO.save(cancion);	
	}

	@Override
	public boolean deleteCancionById(Integer id) {
		this.cancionDAO.deleteById(id);
		return true;
	}

	
}
