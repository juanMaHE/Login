package com.rest.core.service;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.rest.core.converter.Convertidor;
import com.rest.core.entity.Nota;
import com.rest.core.model.MNota;
import com.rest.core.model.MUsuario;
import com.rest.core.repository.GestorUsuario;
import com.rest.core.repository.NotaRepositorio;

@Service("servicio")
public class NotaService {
	private static final Log logger = LogFactory.getLog(NotaService.class);
	
	@Autowired
	@Qualifier("repositorio")
	private NotaRepositorio repositorio;
	
	
	@Autowired
	@Qualifier("convertidor")
	private Convertidor convertidor;

	public boolean crear(Nota nota) {
		logger.debug("Creando Nota");
		try {
			repositorio.save(nota);
			return true;
		} catch (Exception e) {
			logger.error("Error al insertar", e);
			return false;
			// TODO: handle exception
		}
	}

	public boolean actualizar(Nota nota) {
		try {
			repositorio.save(nota);
			return true;
		} catch (Exception e) {
			return false;
			// TODO: handle exception
		}
	}

	public boolean borrar(String nombre, long id) {
		try {
			Nota nota = repositorio.findByNombreAndId(nombre, id);
			repositorio.delete(nota);
			return true;
		} catch (Exception e) {
			return false;
			// TODO: handle exception
		}
	}
	
	public List<MNota> obtener() {
//		List<MNota> notas=null;
//		List<Nota> notasEn=repositorio.findAll();
//		return convertidor.convertirLista(notasEn);
		return convertidor.convertirLista(repositorio.findAll());
	}
	

	
//	public abstract Nota findByNombre(String nombre);
//
//	public abstract List<Nota> findByTitulo(String titulo);
//
//	public abstract Nota findByNombreAndTitulo(String nombre, String titulo);
//	
//	public abstract Nota findByNombreAndId(String nombre, long id);
	public MNota obtenerNombreNota(String nombre) {
		return new MNota(repositorio.findByNombre(nombre));
	} 
	
	public List<MNota> buscarPorTitulo(String titulo){
		return convertidor.convertirLista(repositorio.findByTitulo(titulo));
	}
	
	public MNota buscarPorNombreTitulo(String nombre, String titulo) {
		return new MNota(repositorio.findByNombreAndTitulo(nombre, titulo));
	}

	public MNota buscarNombreId(String nombre, long id) {
		return new MNota(repositorio.findByNombreAndId(nombre, id));
	}
	
	public List<MNota> obtenerPorPaginacion(Pageable pageable){
		return convertidor.convertirLista(repositorio.findAll(pageable).getContent());
	}
		
	
}
