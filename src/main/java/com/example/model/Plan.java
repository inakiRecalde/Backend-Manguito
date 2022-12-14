package com.example.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.*;

@Entity
@Table(name="PLANES")
public class Plan {

	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(name="CANT_MANGUITOS")
	private double cantManguitos;
	
	@Column(name="BENEFICIO")
	private String beneficio;
	
	@OneToMany(cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties(value="plan")
	private List<Donacion> donaciones;
	
	@ManyToOne(cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties(value="planes")
	private Emprendimiento emprendimiento;
	
	public Emprendimiento getEmprendimiento() {
		return emprendimiento;
	}

	public void setEmprendimiento(Emprendimiento emprendimiento) {
		this.emprendimiento = emprendimiento;
	}

	public Plan() {
	}
	
	public Plan(double manguitos, String beneficio) {
		this.cantManguitos = manguitos;
		this.beneficio = beneficio;
		this.donaciones = new ArrayList<Donacion>();
	}

	public double getCantManguitos() {
		return cantManguitos;
	}

	public void setCantManguitos(double cantManguitos) {
		this.cantManguitos = cantManguitos;
	}

	public String getBeneficio() {
		return beneficio;
	}

	public void setBeneficio(String beneficio) {
		this.beneficio = beneficio;
	}
	
	public List<Donacion> getDonaciones() {
		return donaciones;
	}

	public void setDonaciones(List<Donacion> donaciones) {
		this.donaciones = donaciones;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
