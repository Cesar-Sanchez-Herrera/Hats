package com.survivor.model.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import com.survivor.model.entity.Cancion;

public interface ICancionDAO extends JpaRepository<Cancion, Integer> {


	
}
