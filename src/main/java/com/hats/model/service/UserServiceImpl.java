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

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private IUserDAO userDAO;

	@Override
	public List<User> getAllUsers() {
		return (List<User>) userDAO.findAll();
	}

	@Override
	public User getUserById(Integer id) {
		User user = this.userDAO.findById(id).orElse(null);
		return user;
	}

	@Override
	public User addUser(User user) {
		return this.userDAO.save(user);
	}

	@Override
	public User updateUser(User user) {
		return userDAO.save(user);
	}

	@Override
	public boolean deleteUserById(Integer id) {
		this.userDAO.deleteById(id);
		return true;
	}
	

}
