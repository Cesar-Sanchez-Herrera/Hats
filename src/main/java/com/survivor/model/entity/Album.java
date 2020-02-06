package com.survivor.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name ="Album")
public class Album implements Serializable{

	private static final long serialVersionUID = 1L;

	
	@Id
	@GeneratedValue
	private Integer album_id;
}