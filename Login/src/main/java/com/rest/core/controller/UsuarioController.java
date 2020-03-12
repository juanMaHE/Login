package com.rest.core.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.rest.core.entity.Usuario;
import com.rest.core.model.MUsuario;
import com.rest.core.service.UsuarioService;

@RestController
@RequestMapping("/v2")
public class UsuarioController {

	@Autowired
	@Qualifier("usuarioService")
	UsuarioService UServ;
	
	
	@PutMapping("/agregarUsr")
	@PreAuthorize("hasRole('ADMINISTRADOR')")
	public boolean agregarNota(@RequestBody @Valid Usuario usuario) {
		try {
		return UServ.crearUsuario(usuario);
		} catch (Exception e) {
			return false;
			
		}
		
	}
	
	@GetMapping("/usuarios")
	public List<MUsuario> regresaUsuarios(Pageable pageable) {
		try {
		return UServ.obtenerPorPaginacion(pageable);
		} catch (Exception e) {
			return null;
			
		}
		
	}
	
	@GetMapping("/usuario/{usuario}/{contrasenia}")
	@PreAuthorize("hasRole('Super Administrador')")
	public MUsuario regresaUsuario(@PathVariable("usuario") String usuario,
			@PathVariable("contrasenia") String contrasenia) {
		try {
		return UServ.obtenerUSuario(usuario, contrasenia);
		} catch (Exception e) {
			return null;
			
		}
		
	}
	
}
