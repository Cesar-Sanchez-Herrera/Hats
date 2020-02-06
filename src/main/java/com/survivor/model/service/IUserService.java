package com.survivor.model.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.survivor.model.entity.User;

public interface IUserService {
	
	public List<User> findAll();
	public Page<User> findAll(Pageable pageable);
	public User findByID(Integer id);
	public User save(User usr);
	public void delete(Integer id);


}
