package com.survivor.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name ="User_Artista")
public class UserArtista implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "cancion_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer user_artista_id;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="artista_id")
	private Artista artista_id;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="user_id")
	private User user_id;
	
	private String username;
	private String password;
	public Integer getUser_artista_id() {
		return user_artista_id;
	}
	public void setUser_artista_id(Integer user_artista_id) {
		this.user_artista_id = user_artista_id;
	}
	public Artista getArtista_id() {
		return artista_id;
	}
	public void setArtista_id(Artista artista_id) {
		this.artista_id = artista_id;
	}
	public User getUser_id() {
		return user_id;
	}
	public void setUser_id(User user_id) {
		this.user_id = user_id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
