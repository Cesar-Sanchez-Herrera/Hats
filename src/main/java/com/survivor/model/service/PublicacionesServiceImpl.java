package com.survivor.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.survivor.model.dao.ICancionDAO;
import com.survivor.model.entity.Cancion;

@Service
public class PublicacionesServiceImpl implements ICancionService {

	@Autowired
	private ICancionDAO cancionDAO;
	
	@Override
	@Transactional(readOnly = true)
	public List<Cancion> findAll() {
		return (List<Cancion>) cancionDAO.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Cancion findByID(Integer id) {
		return cancionDAO.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Cancion save(Cancion can) {
		return cancionDAO.save(can);
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		cancionDAO.deleteById(id);
	}

	@Override
	@Transactional
	public Page<Cancion> findAll(Pageable pageable) {
		return cancionDAO.findAll(pageable);
	}

	
	

}
