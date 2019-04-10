package com.registerLab.DAO ;

import java.sql.Date;

import com.registerLab.entities.Equipo;

public interface EquipoDAO{

	Equipo getEquipo(int id);
	
	void insertarEquipo(int id,Date fechainicioactividad,Date fechafinactividad,Date fechaadquisicion, int laboratorio);

}