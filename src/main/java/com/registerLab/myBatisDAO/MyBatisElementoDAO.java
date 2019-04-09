package com.registerLab.myBatisDAO;

import com.google.inject.Inject;
import com.registerLab.DAO.ElementoDAO;
import com.registerLab.DAO.EquipoDAO;
import com.registerLab.entities.Elemento;
import com.registerLab.entities.Equipo;
import com.registerLab.mappers.ElementoMapper;
import com.registerLab.mappers.EquipoMapper;

public class MyBatisElementoDAO implements ElementoDAO{
	@Inject
	private ElementoMapper mapper;
	
	@Override
	public Elemento getElemento(int id) {
		return mapper.getElemento(id);
	}

}