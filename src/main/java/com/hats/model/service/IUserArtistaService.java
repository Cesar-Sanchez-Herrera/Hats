package com.hats.model.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.hats.model.entity.Publicaciones;
import com.hats.model.entity.UserArtista;

public interface IUserArtistaService {
	
	public List<UserArtista> getAllUserArtistas();
	public UserArtista getUserArtistaById(Integer id);
	public UserArtista addUserArtista(UserArtista userartista);
	public UserArtista updateUserArtista(UserArtista userartista);
	public boolean deleteUserArtistaById(Integer id);


}
