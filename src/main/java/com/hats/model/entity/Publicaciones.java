package com.hats.model.entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name ="Publicaciones")
public class Publicaciones implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Integer publicaciones_id;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="user_artista_id")
	private UserArtista user_artista_id;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="link_publicacion_id")
	private Link link_publicacion_id;
	
	private Date fecha_publicacion;

	public Integer getPublicaciones_id() {
		return publicaciones_id;
	}

	public void setPublicaciones_id(Integer publicaciones_id) {
		this.publicaciones_id = publicaciones_id;
	}

	public UserArtista getUser_artista_id() {
		return user_artista_id;
	}

	public void setUser_artista_id(UserArtista user_artista_id) {
		this.user_artista_id = user_artista_id;
	}

	public Link getLink_publicacion_id() {
		return link_publicacion_id;
	}

	public void setLink_publicacion_id(Link link_publicacion_id) {
		this.link_publicacion_id = link_publicacion_id;
	}

	public Date getFecha_publicacion() {
		return fecha_publicacion;
	}

	public void setFecha_publicacion(Date fecha_publicacion) {
		this.fecha_publicacion = fecha_publicacion;
	}
	
	
	
	
	
	
}
