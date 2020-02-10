package com.hats.model.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.hats.model.entity.Publicaciones;
import com.hats.model.entity.User;

//Servicio de Usuarios//

public interface IUserService {
	
	public List<User> getAllUsers();
	public User getUserById(Integer id);
	public User addUser(User user);
	public User updateUser(User user);
	public boolean deleteUserById(Integer id);


}
