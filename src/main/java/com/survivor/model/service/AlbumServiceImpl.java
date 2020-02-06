package com.survivor.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.survivor.model.dao.IAlbumDAO;
import com.survivor.model.entity.Album;

@Service
public class AlbumServiceImpl implements IAlbumService {

	@Autowired
	private IAlbumDAO albumDAO;
	
	@Override
	@Transactional(readOnly = true)
	public List<Album> findAll() {
		return (List<Album>) albumDAO.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Album findByID(Integer id) {
		return albumDAO.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Album save(Album alb) {
		return albumDAO.save(alb);
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		albumDAO.deleteById(id);
	}

	@Override
	@Transactional
	public Page<Album> findAll(Pageable pageable) {
		return albumDAO.findAll(pageable);
	}

	
	

}
