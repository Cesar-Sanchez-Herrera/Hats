package com.survivor.model.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import com.survivor.model.entity.UserArtista;

public interface IUserArtistaDAO extends JpaRepository<UserArtista, Integer> {


	
}
