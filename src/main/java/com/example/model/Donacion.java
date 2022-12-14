package com.example.model;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.*;

@Entity
@Table(name="DONACIONES")
public class Donacion {
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

	@Column(name="CANT_MANGUITOS")
	private double cantManguitos;
	
	@Column(name="MONTO_DONADO")
	private double montoDonado;
	
	@Column(name="NOMBRE_DONANTE")
	private String nombreDonante;
	
	@Column(name="CONTACTO")
	private String contacto;	//recuperar
	
	@Column(name="MENSAJE")
	private String mensaje;
	
	@OneToOne(optional = false,  cascade = CascadeType.REMOVE)
	private Emprendimiento emprendimiento;
	
	@ManyToOne(cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties(value="donaciones")
	private Plan plan;
	
	public Donacion() {
	}
	
	public Donacion(double manguitos, double monto, String contacto, String nombre, String mensaje, Emprendimiento emprendimiento, Plan plan) {
		this.cantManguitos = manguitos;
		this.montoDonado = monto;
		this.nombreDonante = nombre;
		this.contacto = contacto;
		this.mensaje = mensaje;
		this.emprendimiento = emprendimiento;
		this.plan = plan;
	}
	
	
	
	public Plan getPlan() {
		return plan;
	}

	public void setPlan(Plan plan) {
		this.plan = plan;
	}

	public double getCantManguitos() {
		return cantManguitos;
	}
	public void setCantManguitos(double cantManguitos) {
		this.cantManguitos = cantManguitos;
	}
	public String getNombreDonante() {
		return nombreDonante;
	}
	public void setNombreDonante(String nombreDonante) {
		this.nombreDonante = nombreDonante;
	}
	public String getContacto() {
		return contacto;
	}
	public void setContacto(String contacto) {
		this.contacto = contacto;
	}
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	public Emprendimiento getEmprendimiento() {
		return emprendimiento;
	}
	public void setEmprendimiento(Emprendimiento emprendimiento) {
		this.emprendimiento = emprendimiento;
	}

	public double getMontoDonado() {
		return montoDonado;
	}

	public void setMontoDonado(double montoDonado) {
		this.montoDonado = montoDonado;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	
}
