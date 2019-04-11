package com.registerLab.myBatisDAO;

import java.sql.Date;
import java.util.ArrayList;

import com.google.inject.Inject;
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
	public void insertarEquipo(int id,Date fechainicioactividad,Date fechafinactividad,Date fechaadquisicion, int laboratorio,ArrayList<Elemento> elementos) {
		mapper.insertarEquipo(id,fechainicioactividad,fechafinactividad,fechaadquisicion,laboratorio,elementos);
	}

}