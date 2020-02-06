package com.survivor.model.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.survivor.model.entity.UserArtista;

public interface IUserArtistaService {
	
	public List<UserArtista> findAll();
	public Page<UserArtista> findAll(Pageable pageable);
	public UserArtista findByID(Integer id);
	public UserArtista save(UserArtista usrart);
	public void delete(Integer id);


}
