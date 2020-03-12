package com.rest.core.repository;


import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.rest.core.entity.Usuario;

@Repository("gestorUsuario")
public interface GestorUsuario
		extends JpaRepository<Usuario, Long>, PagingAndSortingRepository<Usuario, Long> {

	Optional< Usuario>findByNombreUsuario(String usuario);

	public abstract Usuario findByNombreUsuarioAndContrasenia(String usuario,String contrasenia);
	
	public abstract Page<Usuario> findAll(Pageable pageable);

}
