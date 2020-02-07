package com.hats.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hats.model.dao.IAlbumDAO;
import com.hats.model.entity.Album;

@Service
public class AlbumServiceImpl implements IAlbumService {

	@Autowired
	private IAlbumDAO albumDAO;
	
	@Override
	public List<Album> getAllAlbums() {
		return (List<Album>) albumDAO.findAll();
	}

	public Album getAlbumById(final Integer id) {
		Album album = this.albumDAO.findById(id).orElse(null);
		return album;
	}

	public Album addAlbum(final Album album){
			return this.albumDAO.save(album);	
	}
	
	public Album updateAlbum(final Album album) {
		return albumDAO.save(album);	
	}
	
	@Override
	public boolean deleteAlbumById(Integer id) {
		this.albumDAO.deleteById(id);
		return true;
	}
	
	

}
