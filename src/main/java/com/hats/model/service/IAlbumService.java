package com.hats.model.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.hats.model.entity.Album;

public interface IAlbumService {
	
	public List<Album> getAllAlbums();
	public Album getAlbumById(Integer id);
	public Album addAlbum(Album album);
	public Album updateAlbum(Album album);
	public boolean deleteAlbumById(Integer id);

}
