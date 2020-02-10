package com.hats.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hats.model.dao.IUserDAO;
import com.hats.model.entity.Publicaciones;
import com.hats.model.entity.User;

//Implementacion de servicio de Usuarios//

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private IUserDAO userDAO;

	//Obtener todos los usuarios//
	@Override
	public List<User> getAllUsers() {
		return (List<User>) userDAO.findAll();
	}

	//Obtener un usuario por id//
	@Override
	public User getUserById(Integer id) {
		User user = this.userDAO.findById(id).orElse(null);
		return user;
	}

	//Añadir un usuario//
	@Override
	public User addUser(User user) {
		return this.userDAO.save(user);
	}

	//Modificar un usuario//
	@Override
	public User updateUser(User user) {
		return userDAO.save(user);
	}

	//Borrar un usuario//
	@Override
	public boolean deleteUserById(Integer id) {
		this.userDAO.deleteById(id);
		return true;
	}
	

}
