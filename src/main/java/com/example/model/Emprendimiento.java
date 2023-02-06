package com.example.model;


import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.*;

@Entity
@Table(name="EMPRENDIMIENTOS")
public class Emprendimiento {

	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(name="DOMINIO")
	private String dominio; //recuperar
	
	@Column(name="PASSWORD")
	private String password;
	
	@Column(name="NOMBRE")
	private String nombre;
	
	@Column(name="DESCRIPCION")
	private String descripcion;
	
	@Column(name="PRECIO_POR_MANGUITO")
	private double precioPorManguito;

	@Column(name="MANGUITOS_RECIBIDOS")
	private double manguitosRecibidos;
	
	@OneToMany(mappedBy="emprendimiento", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties(value="emprendimiento")
	private List<Url> redesSociales;
	
	@OneToMany(mappedBy="emprendimiento", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties(value="emprendimiento")
	private List<Posteo> posteos;
	
	@ManyToMany(mappedBy = "emprendimientos")
	@JsonIgnoreProperties(value="emprendimientos")
	private List<Categoria> categorias;
	
	@OneToMany(mappedBy="emprendimiento" , cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties(value="emprendimiento")
	private List<Plan> planes; 
	
	public Emprendimiento() {
	}
	
	public Emprendimiento(String dominio, String password) {
		this.dominio = dominio;
		this.password = password;
		this.nombre = "Sin Nombre";
		this.descripcion = "Sin Descripcion";
		this.precioPorManguito = 1;
		this.manguitosRecibidos = 0;
		this.redesSociales = new ArrayList<Url>();
		this.posteos = new ArrayList<Posteo>();
		this.categorias = new ArrayList<Categoria>();
		this.planes = new ArrayList<Plan>();
		
	}
	
	public String getDominio() {
		return dominio;
	}

	public void setDominio(String dominio) {
		this.dominio = dominio;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
/*
	public Image getBanner() {
		return banner;
	}

	public void setBanner(Image banner) {
		this.banner = banner;
	}
*/
	/*
	public boolean isMostrarTop() {
		return mostrarTop;
	}

	public void setMostrarTop(boolean mostrarTop) {
		this.mostrarTop = mostrarTop;
	} */

	public double getPrecioPorManguito() {
		return precioPorManguito;
	}

	public void setPrecioPorManguito(double precioPorManguito) {
		this.precioPorManguito = precioPorManguito;
	}

	public double getManguitosRecibidos() {
		return manguitosRecibidos;
	}

	public void setManguitosRecibidos(double manguitosRecibidos) {
		this.manguitosRecibidos = manguitosRecibidos;
	}

	public List<Url> getRedesSociales() {
		return redesSociales;
	}

	public void setRedesSociales(List<Url> redesSociales) {
		this.redesSociales = redesSociales;
	}

	public List<Posteo> getPosteos() {
		return posteos;
	}

	public void setPosteos(List<Posteo> posteos) {
		this.posteos = posteos;
	}

	public List<Categoria> getCategorias() {
		return categorias;
	}

	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}

	public List<Plan> getPlanes() {
		return planes;
	}

	public void setPlanes(List<Plan> planes) {
		this.planes = planes;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	
}
