package com.hats.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hats.model.dao.IUserArtistaDAO;
import com.hats.model.entity.Publicaciones;
import com.hats.model.entity.UserArtista;

@Service
public class UserArtistaServiceImpl implements IUserArtistaService {

	@Autowired
	private IUserArtistaDAO userArtistaDAO;

	@Override
	public List<UserArtista> getAllUserArtistas() {
		return (List<UserArtista>) userArtistaDAO.findAll();
	}

	@Override
	public UserArtista getUserArtistaById(Integer id) {
		UserArtista userartista = this.userArtistaDAO.findById(id).orElse(null);
		return userartista;
	}

	@Override
	public UserArtista addUserArtista(UserArtista userartista) {
		return this.userArtistaDAO.save(userartista);
	}

	@Override
	public UserArtista updateUserArtista(UserArtista userartista) {
		return userArtistaDAO.save(userartista);
	}

	@Override
	public boolean deleteUserArtistaById(Integer id) {
		this.userArtistaDAO.deleteById(id);
		return true;
	}
	
}