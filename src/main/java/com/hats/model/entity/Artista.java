package com.hats.model.entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="artista")
public class Artista implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private Integer artista_id;
	
	private String nombre_artistico;
	private String nombre;
	private Date debut;
	private Integer edad;
	private String nacionalidad;
	private String generos;
	private Boolean certificacion;
	public Integer getArtista_id() {
		return artista_id;
	}
	public void setArtista_id(Integer artista_id) {
		this.artista_id = artista_id;
	}
	public String getNombre_artistico() {
		return nombre_artistico;
	}
	public void setNombre_artistico(String nombre_artistico) {
		this.nombre_artistico = nombre_artistico;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Date getDebut() {
		return debut;
	}
	public void setDebut(Date debut) {
		this.debut = debut;
	}
	public Integer getEdad() {
		return edad;
	}
	public void setEdad(Integer edad) {
		this.edad = edad;
	}
	public String getNacionalidad() {
		return nacionalidad;
	}
	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}
	public String getGeneros() {
		return generos;
	}
	public void setGeneros(String generos) {
		this.generos = generos;
	}
	public Boolean getCertificacion() {
		return certificacion;
	}
	public void setCertificacion(Boolean certificacion) {
		this.certificacion = certificacion;
	}
	
	
}
