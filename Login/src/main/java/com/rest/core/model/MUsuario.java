package com.rest.core.model;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.rest.core.entity.Rol;
import com.rest.core.entity.Usuario;


public class MUsuario {

	private long id;

	private String nombre;

	private String aps;

	private String correo;
	
	private String cargo;

	private Rol rol;

	private String nombreUsuario;

	private String contrasenia;

	private Date fechaEdicion;

	private Date fechaRegistro;

	private boolean estatus;
	
	Format formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	

	public MUsuario(Usuario usuario) {
		this.id = usuario.getId();
		this.nombre = usuario.getNombre();
		this.aps = usuario.getAps();
		this.correo = usuario.getCorreo();
		this.cargo = usuario.getCargo();
		this.rol = usuario.getRol();
		this.nombreUsuario = usuario.getNombreUsuario();
		this.contrasenia = usuario.getContrasenia();
		this.fechaEdicion = usuario.getFechaRegistro();
		this.fechaRegistro = usuario.getFechaRegistro();
		this.estatus = usuario.getEstatus();
	}

public MUsuario() {}


	public MUsuario(long id, String nombre, String aps, String correo, String cargo, Rol rol, String nombreUsuario,
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

	public boolean isEstatus() {
		return estatus;
	}

	public void setEstatus(boolean estatus) {
		this.estatus = estatus;
	}

	
	
}
