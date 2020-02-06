package com.survivor.model.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import com.survivor.model.entity.User;

public interface IUserDAO extends JpaRepository<User, Integer> {


	
}
