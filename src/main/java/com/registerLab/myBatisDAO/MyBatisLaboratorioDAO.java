package com.registerLab.myBatisDAO;

import com.google.inject.Inject;
import com.registerLab.DAO.EquipoDAO;
import com.registerLab.DAO.LaboratorioDAO;
import com.registerLab.entities.Equipo;
import com.registerLab.entities.Laboratorio;
import com.registerLab.mappers.EquipoMapper;
import com.registerLab.mappers.LaboratorioMapper;

public class MyBatisLaboratorioDAO implements LaboratorioDAO{
	
	@Inject
	private LaboratorioMapper mapper;
	
	@Override
	public Laboratorio getLaboratorio(int id) {
		return mapper.getLaboratorio(id);
	}

}