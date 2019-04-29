package com.registerLab.DAO ;

import java.sql.Date;

import com.registerLab.ECILabException;
import com.registerLab.entities.Equipo;
import com.registerLab.entities.Laboratorio;

public interface LaboratorioDAO{

	Laboratorio getLaboratorio(int id);
	
	void agregarLaboratorio(int id, String nombre, int capacidad, Date fechacierre) throws ECILabException;

	void asociarEquipo(int idEquipo, int idLaboratorioN);

}