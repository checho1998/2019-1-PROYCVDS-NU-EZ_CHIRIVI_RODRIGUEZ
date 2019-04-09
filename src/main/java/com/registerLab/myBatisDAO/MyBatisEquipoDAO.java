package com.registerLab.myBatisDAO;

import com.google.inject.Inject;
import com.registerLab.DAO.EquipoDAO;
import com.registerLab.entities.Equipo;
import com.registerLab.mappers.EquipoMapper;

public class MyBatisEquipoDAO implements EquipoDAO{
	@Inject
	private EquipoMapper mapper;
	
	@Override
	public Equipo getEquipo(int id) {
		return mapper.getEquipo(id);
	}

}