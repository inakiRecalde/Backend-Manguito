package com.example.model;
import jakarta.persistence.*;

@Entity
@Table(name="CATEGORIAS")
public class Categoria {

	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(name="NOMBRE")
	private String nombre;
	
	
	public Categoria() {
		super();
	}

	
	public Categoria(Long id, String nombre) {
		this.id = id;
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
	
	
}
