package com.registerLab.myBatisDAO;

import java.sql.Date;

import com.google.inject.Inject;
import com.registerLab.ECILabException;
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
	
	public void asociarEquipo(int idEquipo, int idLaboratorioN) {	
		
	}
	@Override
	public void agregarLaboratorio(int id, String nombre, int capacidad, Date fechacierre) throws ECILabException {
		if (getLaboratorio(id) != null) throw new ECILabException ("Este laboratorio ya esta registrado");
		if (nombre == null || nombre == "") throw new ECILabException ("El nombre del laboratorio no debe estar vacio");
		mapper.agregarLaboratorio(id, nombre, capacidad, fechacierre);
	}
}