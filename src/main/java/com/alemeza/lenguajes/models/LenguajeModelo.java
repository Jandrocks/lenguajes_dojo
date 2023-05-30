package com.alemeza.lenguajes.models;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;


@Entity
@Table(name = "lenguajes")
public class LenguajeModelo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message="Por favor ingresa el nombre")
	private String name;
	
	@NotBlank(message="Por favor ingresa el creador")
	private String nameCreator;
	
	@Min(value = 1, message="Por favor agrega la version" )
	private float version;
	
	@Column(updatable = false)
	private Date createdAt;
	private Date updatedAt;
	
	public LenguajeModelo() {		
	}
	
	public LenguajeModelo(String name, String nameCreator, float version) {
		this.name = name;
		this.nameCreator = nameCreator;
		this.version = version;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNameCreator() {
		return nameCreator;
	}

	public void setNameCreator(String nameCreator) {
		this.nameCreator = nameCreator;
	}

	public float getVersion() {
		return version;
	}

	public void setVersion(float version) {
		this.version = version;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	

	
}
