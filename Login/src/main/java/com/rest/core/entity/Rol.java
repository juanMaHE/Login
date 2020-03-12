package com.rest.core.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="rol",schema = "catalogos")
public class Rol {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name="id_rol", unique = true)
	private long id_rol;	
	
	@Column(name="rol")
	private String rol;
	
	@Column(name="fecha_edicion")	
	private Date fecha_edicion;	
	
	@Column(name="fecha_registro")
	private Date fecha_registro;
	
	@Column(name="estatus")
	private boolean estatus;


	public Rol(long id_rol, String rol, Date fecha_edicion, Date fecha_registro, boolean estatus) {
		this.id_rol = id_rol;
		this.rol = rol;
		this.fecha_edicion = fecha_edicion;
		this.fecha_registro = fecha_registro;
		this.estatus = estatus;
	}

	public Rol() {
		
	}

	public long getId_rol() {
		return id_rol;
	}

	public void setId_rol(long id_rol) {
		this.id_rol = id_rol;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	public Date getFecha_edicion() {
		return fecha_edicion;
	}

	public void setFecha_edicion(Date fecha_edicion) {
		this.fecha_edicion = fecha_edicion;
	}

	public Date getFecha_registro() {
		return fecha_registro;
	}

	public void setFecha_registro(Date fecha_registro) {
		this.fecha_registro = fecha_registro;
	}

	public boolean isEstatus() {
		return estatus;
	}

	public void setEstatus(boolean estatus) {
		this.estatus = estatus;
	}
	
	
	
	
}
