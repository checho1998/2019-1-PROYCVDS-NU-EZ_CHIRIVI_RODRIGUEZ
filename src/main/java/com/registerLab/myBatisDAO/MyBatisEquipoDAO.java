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
	public void insertarEquipo(int id,Date fechainicioactividad,Date fechafinactividad,Date fechaadquisicion, int laboratorio,ArrayList<Elemento> elementos) 
			throws ECILabException{
		if(fechafinactividad == null) {
			if(elementos.size() == 4) {
				mapper.insertarEquipo(id,fechainicioactividad,fechafinactividad,fechaadquisicion,laboratorio,elementos);
			}
			else {
				throw new ECILabException ("Se necesitan los elementos necesarios para su funcionamiento");
			}
		}
		else {
			throw new ECILabException ("El equipo ingresado no esta disponible para asociarlo a un laboratorio");
		}
	}

}