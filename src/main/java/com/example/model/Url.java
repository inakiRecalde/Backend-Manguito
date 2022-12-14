package com.example.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.*;

@Entity
@Table(name="URLS")
public class Url {
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(name="NOMBRE")
	private String nombre;
	
	@Column(name="URL")
	private String url;
	
	@ManyToOne(cascade = CascadeType.REMOVE)
	@JoinColumn(name="emprendimiento_id")
	@JsonIgnoreProperties(value="redeSociales")
	private Emprendimiento emprendimiento;
	
	public Url() {	}
	
	public Emprendimiento getEmprendimiento() {
		return emprendimiento;
	}

	public void setEmprendimiento(Emprendimiento emprendimiento) {
		this.emprendimiento = emprendimiento;
	}

	public Url(String nombre, String url) {
		this.nombre = nombre;
		this.url = url;	//recuperar
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
}
