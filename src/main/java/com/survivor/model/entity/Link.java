package com.survivor.model.entity;

import java.io.Serializable;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="Link")
public class Link implements Serializable {
	
	
	private static final long serialVersionUID = 1L;
	
	@Id
    @Column(name = "link_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer link_id;
	private String link;
	private String Tipo;
	
	
	
	public Integer getLink_id() {
		return link_id;
	}
	public void setLink_id(Integer link_id) {
		this.link_id = link_id;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public String getTipo() {
		return Tipo;
	}
	public void setTipo(String tipo) {
		Tipo = tipo;
	}
	
	

}
