package com.registerLab.DAO;

import java.sql.Date;

import com.registerLab.ECILabException;
import com.registerLab.entities.Novedad;

public interface NovedadDAO {
	
		public Novedad getNovedad(int id)throws ECILabException;
		
		public int getUltimaNovedad();
		
		public void agregarNovedad(
		String descripcion,
		String justificacion,
		int idEquipo,
		int idElemento,
		int usuario) throws ECILabException;

		public void registrarNovedadSinEquipo(String descripcion, String justificacion, int elemento, int usuario);
}
