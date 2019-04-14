package com.registerLab.DAO;

import java.sql.Date;

import com.registerLab.entities.Elemento;
import com.registerLab.entities.Equipo;
import com.registerLab.entities.Usuario;
import com.registerLab.ECILabException;

public interface ElementoDAO {
	
	Elemento getElemento(int id);
	
	public void AgregarElemento(int id,
			String categoria,
			String fabricante,
			String referencia,
			Date fechaAdquisicion,
			Date fechaInicioActividad,
			Date fechaFinActividad) throws ECILabException;
}
