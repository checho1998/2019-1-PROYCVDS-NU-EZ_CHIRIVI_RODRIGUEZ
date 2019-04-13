package com.registerLab.DAO ;

import java.sql.Date;
import java.util.ArrayList;

import com.registerLab.ECILabException;
import com.registerLab.entities.Elemento;
import com.registerLab.entities.Equipo;

public interface EquipoDAO{

	Equipo getEquipo(int id);
	
	void insertarEquipoSinLaboratorio(int id,
			Date fechainicioactividad,
			Date fechafinactividad,
<<<<<<< HEAD
			Date fechaadquisicion)throws ECILabException;

=======
			Date fechaadquisicion,
			int laboratorio,
			ArrayList<Elemento> elementos)throws ECILabException;
	
>>>>>>> 8b402c698f478ffd2c715c36fae6bb0f978c66a2
}