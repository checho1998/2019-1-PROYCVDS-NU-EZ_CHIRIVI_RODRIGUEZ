package com.registerLab.DAO ;

import java.sql.Date;
import java.util.ArrayList;

import com.registerLab.ECILabException;
import com.registerLab.entities.Elemento;
import com.registerLab.entities.Equipo;

public interface EquipoDAO{

	Equipo getEquipo(int id);
	
	void insertarEquipoSinLaboratorio(int id,
			Date fechaInicioActividad,
			Date fechafinactividad,
			Date fechaAdquisicion)throws ECILabException;
	
	
	void asociarElemento(ArrayList<Elemento> elemento,int idequipo)throws ECILabException;
	
	void cambioAsociacionElemento(int idElemento, int IdEquipoN)throws ECILabException;
	
}