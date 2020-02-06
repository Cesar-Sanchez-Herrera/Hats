package com.survivor.model.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import com.survivor.model.entity.Artista;

public interface IArtistaDAO extends JpaRepository<Artista, Integer> {
	
}
