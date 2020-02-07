package com.hats.model.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.hats.model.entity.Album;
import com.hats.model.entity.Artista;

public interface IArtistaService {
	
	public List<Artista> getAllArtistas();
	public Artista getArtistaById(Integer id);
	public Artista addArtista(Artista artista);
	public Artista updateArtista(Artista artista);
	public boolean deleteArtistaById(Integer id);


}
