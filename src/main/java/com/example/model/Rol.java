package com.example.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.*;

@Entity
@Table(name="ROLES")
public class Rol {
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(name="ROL")
	private String rol;
	
	@OneToMany(mappedBy="rol", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties(value="rol")
	private List<Usuario> usuarios;

	public Rol() {	}
	
	public Rol(Long id, String rol) {
		super();
		this.id = id;
		this.rol = rol;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}
	
	public Rol(String unRol) {
		this.rol= unRol;	}
}
