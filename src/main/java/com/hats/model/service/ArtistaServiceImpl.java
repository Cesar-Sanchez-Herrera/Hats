package com.hats.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hats.model.dao.IArtistaDAO;
import com.hats.model.entity.Album;
import com.hats.model.entity.Artista;

//Implementacion de servicio de Artista//

@Service
public class ArtistaServiceImpl implements IArtistaService {

	@Autowired
	private IArtistaDAO artistaDAO;

	//Obtener todos los artistas//
	@Override
	public List<Artista> getAllArtistas() {
		return (List<Artista>) artistaDAO.findAll();
	}

	//Obtener un artista por id//
	@Override
	public Artista getArtistaById(Integer id) {
		Artista artista = this.artistaDAO.findById(id).orElse(null);
		return artista;
	}

	//Añadir un artista//
	@Override
	public Artista addArtista(Artista artista) {
		return this.artistaDAO.save(artista);
	}

	//Modificar un artista//
	@Override
	public Artista updateArtista(Artista artista) {
		return artistaDAO.save(artista);	
	}

	//Borrar un artista//
	@Override
	public boolean deleteArtistaById(Integer id) {
		this.artistaDAO.deleteById(id);
		return true;
	}
	
	
	

}
