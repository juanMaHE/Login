package com.rest.core.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.rest.core.entity.Nota;
import com.rest.core.entity.Usuario;
import com.rest.core.model.MNota;
import com.rest.core.model.MUsuario;

@Component("convertidor")
public class Convertidor {

	public List<MNota> convertirLista(List<Nota> notas) {
		List<MNota> mnotas = new ArrayList<>();

//		for (Nota n : notas)
//			mnotas.add(new MNota(n));

		notas.forEach(Nota -> mnotas.add(new MNota(Nota)));
		return mnotas;
	}
	
	public List<MUsuario> convertirListaUsuario(List<Usuario> notas) {
		List<MUsuario> musuario = new ArrayList<>();

//		for (Nota n : notas)
//			mnotas.add(new MNota(n));
		notas.forEach(Usuario -> musuario.add(new MUsuario(Usuario)));
		return musuario;
	}
	
	
	
}
