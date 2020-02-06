package com.survivor.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.survivor.model.dao.IArtistaDAO;
import com.survivor.model.entity.Artista;

@Service
public class ArtistaServiceImpl implements IArtistaService {

	@Autowired
	private IArtistaDAO artistaDAO;
	
	@Override
	@Transactional(readOnly = true)
	public List<Artista> findAll() {
		return (List<Artista>) artistaDAO.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Artista findByID(Integer id) {
		return artistaDAO.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Artista save(Artista art) {
		return artistaDAO.save(art);
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		artistaDAO.deleteById(id);
	}

	@Override
	@Transactional
	public Page<Artista> findAll(Pageable pageable) {
		return artistaDAO.findAll(pageable);
	}

	
	

}
