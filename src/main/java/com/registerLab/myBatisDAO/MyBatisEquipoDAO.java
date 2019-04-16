package com.registerLab.myBatisDAO;

import java.sql.Date;

import java.util.ArrayList;

import com.google.inject.Inject;

import com.registerLab.ECILabException;

import com.registerLab.DAO.EquipoDAO;

import com.registerLab.entities.Elemento;

import com.registerLab.entities.Equipo;

import com.registerLab.mappers.EquipoMapper;

public class MyBatisEquipoDAO implements EquipoDAO{
	
	@Inject
	private EquipoMapper mapper;
	
	
	@Override
	public Equipo getEquipo(int id) {
		return mapper.getEquipo(id);
	}

	@Override
	public void insertarEquipoSinLaboratorio(int id,Date fechainicioactividad,Date fechafinactividad,Date fechaadquisicion) 
			throws ECILabException{
		
		if(getEquipo(id)!=null) throw new ECILabException("Ya existe un equipo con esta id");
		
		if(fechafinactividad != null) throw new ECILabException("El equipo debe estar activo");
	
		mapper.insertarEquipoSinLaboratorio(id, fechainicioactividad, fechafinactividad, fechaadquisicion);
		
	}
	@Override
	public void asociarElemento(ArrayList<Elemento> elemento, int idequipo) throws ECILabException{
		
		if (elemento.size() == 0) throw new ECILabException("No se encuentra ningun elemento");
		
		mapper.asociarElemento(elemento,idequipo);
	}

}