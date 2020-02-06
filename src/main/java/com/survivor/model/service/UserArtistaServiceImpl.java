package com.survivor.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.survivor.model.dao.IUserArtistaDAO;
import com.survivor.model.entity.UserArtista;

@Service
public class UserArtistaServiceImpl implements IUserArtistaService {

	@Autowired
	private IUserArtistaDAO userArtistaDAO;
	
	@Override
	@Transactional(readOnly = true)
	public List<UserArtista> findAll() {
		return (List<UserArtista>) userArtistaDAO.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public UserArtista findByID(Integer id) {
		return userArtistaDAO.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public UserArtista save(UserArtista usrart) {
		return userArtistaDAO.save(usrart);
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		userArtistaDAO.deleteById(id);
	}

	@Override
	@Transactional
	public Page<UserArtista> findAll(Pageable pageable) {
		return userArtistaDAO.findAll(pageable);
	}

	
	

}
