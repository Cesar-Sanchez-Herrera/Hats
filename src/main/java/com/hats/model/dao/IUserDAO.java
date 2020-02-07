package com.hats.model.dao;


import org.springframework.data.repository.CrudRepository;

import com.hats.model.entity.User;

public interface IUserDAO extends CrudRepository<User, Integer> {


	
}
