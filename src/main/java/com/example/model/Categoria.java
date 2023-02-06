package com.example.model;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.*;

@Entity
@Table(name="CATEGORIAS")
public class Categoria {

	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(name="NOMBRE")
	private String nombre;
	
	
	@ManyToMany()
	@JsonIgnoreProperties(value="categorias")
	@JoinTable(
	  name = "categorias_emprendimientos", 
	  joinColumns = @JoinColumn(name = "categoria_id"), 
	  inverseJoinColumns = @JoinColumn(name = "emprendimiento_id"))
	private List<Emprendimiento> emprendimientos;


	public Categoria() {
		super();
	}

	
	public Categoria(String nombre) {
		this.nombre = nombre;
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


	public List<Emprendimiento> getEmprendimientos() {
		return emprendimientos;
	}


	public void setEmprendimientos(List<Emprendimiento> emprendimientos) {
		this.emprendimientos = emprendimientos;
	}
	

}
