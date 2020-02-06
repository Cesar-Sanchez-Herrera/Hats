package com.survivor.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.survivor.model.dao.IUserDAO;
import com.survivor.model.entity.User;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private IUserDAO userDAO;
	
	@Override
	@Transactional(readOnly = true)
	public List<User> findAll() {
		return (List<User>) userDAO.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public User findByID(Integer id) {
		return userDAO.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public User save(User usr) {
		return userDAO.save(usr);
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		userDAO.deleteById(id);
	}

	@Override
	@Transactional
	public Page<User> findAll(Pageable pageable) {
		return userDAO.findAll(pageable);
	}

	
	

}
