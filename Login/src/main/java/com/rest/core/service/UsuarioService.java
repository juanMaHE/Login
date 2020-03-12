package com.rest.core.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.rest.core.converter.Convertidor;
import com.rest.core.entity.Rol;
import com.rest.core.entity.Usuario;
import com.rest.core.model.MUsuario;
import com.rest.core.repository.GestorUsuario;

@Service("usuarioService")
public class UsuarioService implements UserDetailsService {

	@Autowired
	@Qualifier("gestorUsuario")
	private GestorUsuario repo;
	@Autowired
	@Qualifier("convertidor")
	private Convertidor convertidor;

	public boolean crearUsuario(Usuario usuario) {
		try {
			repo.save(usuario);
			return true;
		} catch (Exception e) {
			return false;
			// TODO: handle exception
		}

	}

	public List<MUsuario> obtenerPorPaginacion(Pageable pageable) {
		return convertidor.convertirListaUsuario(repo.findAll(pageable).getContent());
	}

	public MUsuario obtenerUSuario(String usuario, String contrasenia) {
		return new MUsuario(repo.findByNombreUsuarioAndContrasenia(usuario, contrasenia));
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario user = repo.findByNombreUsuario(username)
				.orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado"));

		return new User(user.getNombreUsuario(), user.getContrasenia(), user.getEstatus(), user.getEstatus(),
				user.getEstatus(), user.getEstatus(), roles(user.getRol()));
	}

	public List<GrantedAuthority> roles(Rol rol) {
		List<GrantedAuthority> auths = new ArrayList<>();
		auths.add(new SimpleGrantedAuthority(rol.getRol()));
		return auths;
	}

}
