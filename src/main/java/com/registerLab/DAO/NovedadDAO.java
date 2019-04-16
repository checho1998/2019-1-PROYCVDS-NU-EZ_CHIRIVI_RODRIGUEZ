package com.registerLab.DAO;

import java.sql.Date;

import com.registerLab.ECILabException;
import com.registerLab.entities.Novedad;

public interface NovedadDAO {
	
		public Novedad getNovedad(int id)throws ECILabException;
		
		public int getUltimaNovedad();
		
		public void agregarNovedad(
		int id,
		Date fechaNovedad,
		String descripcion,
		String justificacion,
		int idEquipo,
		int idElemento) throws ECILabException;
}
