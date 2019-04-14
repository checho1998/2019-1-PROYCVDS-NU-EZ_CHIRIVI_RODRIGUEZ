package com.registerLab.myBatisDAO;

import java.sql.Date;

import com.google.inject.Inject;
import com.registerLab.ECILabException;
import com.registerLab.DAO.ElementoDAO;
import com.registerLab.entities.Elemento;
import com.registerLab.mappers.ElementoMapper;


public class MyBatisElementoDAO implements ElementoDAO{
	@Inject
	private ElementoMapper mapper;
	
	@Override
	public Elemento getElemento(int id) {
		
		return mapper.getElemento(id);
		
	}
	
	@Override
	public void AgregarElemento(int id, String categoria, String fabricante, String referencia, Date fechaAdquisicion, Date fechaInicioActividad, Date fechaFinActividad) 
			throws ECILabException {
		if(getElemento(id)!= null) throw new ECILabException("Ya existe un Elemento con esta id");
		
		if(fechaFinActividad != null) throw new ECILabException("la fecha fin de actividad debe ser nula");
		
		mapper.AgregarElemento(id, categoria, fabricante, referencia, fechaAdquisicion, fechaInicioActividad, fechaFinActividad);
		
	}

}