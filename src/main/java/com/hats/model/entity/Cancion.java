package com.hats.model.entity;

import java.io.Serializable;
import java.sql.Date;

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
@Table(name ="Cancion")
public class Cancion implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "cancion_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cancion_id;
	
	private String titulo;
	private String genero;
	private Integer duracion;
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="artista_id")
	private Artista artista_id;
	private String autor;
	private Date fecha_publicacion;
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="album_id")
	private Album album_id;
	public Integer getCancion_id() {
		return cancion_id;
	}
	public void setCancion_id(Integer cancion_id) {
		this.cancion_id = cancion_id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public Integer getDuracion() {
		return duracion;
	}
	public void setDuracion(Integer duracion) {
		this.duracion = duracion;
	}
	public Artista getArtista_id() {
		return artista_id;
	}
	public void setArtista_id(Artista artista_id) {
		this.artista_id = artista_id;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public Date getFecha_publicacion() {
		return fecha_publicacion;
	}
	public void setFecha_publicacion(Date fecha_publicacion) {
		this.fecha_publicacion = fecha_publicacion;
	}
	public Album getAlbum_id() {
		return album_id;
	}
	public void setAlbum_id(Album album_id) {
		this.album_id = album_id;
	}
	
	
	
	
	
}
