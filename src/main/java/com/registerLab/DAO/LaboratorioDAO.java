package com.registerLab.DAO ;

import java.sql.Date;
import java.util.List;

import com.registerLab.ECILabException;
import com.registerLab.entities.Equipo;
import com.registerLab.entities.Laboratorio;

public interface LaboratorioDAO{

	Laboratorio getLaboratorio(int id);
	
	void agregarLaboratorio(int id, String nombre, int capacidad, Date fechacierre) throws ECILabException;

<<<<<<< HEAD
	void asociarEquipo(int idEquipo, int idLaboratorioN);
	
	List<Laboratorio> getLaboratorios();
=======
	void asociarEquipo(int idEquipo, int idLaboratorioN) throws ECILabException;

	public List<Laboratorio> getLaboratorios();

>>>>>>> b792b526ce3b7553934d5447b007da8d27932e5a
}