package com.rest.core.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.ForeignKey;

@Entity
@Table(name = "usuario",schema = "catalogos")
public class Usuario implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3846394731209089675L;
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Id
	@Column(name = "id_usuario", unique = true)
	private long id;

	@Column(name = "nombre")
	private String nombre;

	@Column(name = "apellidos")
	private String aps;

	@Column(name = "correo", unique = true)
	private String correo;

	@Column(name = "cargo")
	private String cargo;

	@ManyToOne
	@JoinColumn(name = "id_rol", columnDefinition = "int4 DEFAULT NULL",
	foreignKey = @ForeignKey(name = "fk01_usuario_rol"))
	private Rol rol;

	@Column(name = "nombre_usuario", unique = true)
	private String nombreUsuario;

	@Column(name = "contrasenia")
	private String contrasenia;

	@Column(name = "fecha_edicion")
	private Date fechaEdicion;

	@Column(name = "fecha_registro")
	private Date fechaRegistro;

	@Column(name = "estatus")
	private boolean estatus;

	public Usuario() {

	}

	public Usuario(long id, String nombre, String aps, String correo, String cargo, Rol rol, String nombreUsuario,
			String contrasenia, Date fechaEdicion, Date fechaRegistro, boolean estatus) {
		this.id = id;
		this.nombre = nombre;
		this.aps = aps;
		this.correo = correo;
		this.cargo = cargo;
		this.rol = rol;
		this.nombreUsuario = nombreUsuario;
		this.contrasenia = contrasenia;
		this.fechaEdicion = fechaEdicion;
		this.fechaRegistro = fechaRegistro;
		this.estatus = estatus;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getAps() {
		return aps;
	}

	public void setAps(String aps) {
		this.aps = aps;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

	public Date getFechaEdicion() {
		return fechaEdicion;
	}

	public void setFechaEdicion(Date fechaEdicion) {
		this.fechaEdicion = fechaEdicion;
	}

	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public boolean getEstatus() {
		return estatus;
	}

	public void setEstatus(boolean estatus) {
		this.estatus = estatus;
	}

}
