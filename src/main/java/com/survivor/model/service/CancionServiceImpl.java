package com.survivor.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.survivor.model.dao.IPublicacionesDAO;
import com.survivor.model.entity.Publicaciones;

@Service
public class CancionServiceImpl implements IPublicacionesService {

	@Autowired
	private IPublicacionesDAO publicacionesDAO;
	
	@Override
	@Transactional(readOnly = true)
	public List<Publicaciones> findAll() {
		return (List<Publicaciones>) publicacionesDAO.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Publicaciones findByID(Integer id) {
		return publicacionesDAO.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public 	Publicaciones save(Publicaciones publi) {
		return publicacionesDAO.save(publi);
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		publicacionesDAO.deleteById(id);
	}

	@Override
	@Transactional
	public Page<Publicaciones> findAll(Pageable pageable) {
		return publicacionesDAO.findAll(pageable);
	}

	
	

}
