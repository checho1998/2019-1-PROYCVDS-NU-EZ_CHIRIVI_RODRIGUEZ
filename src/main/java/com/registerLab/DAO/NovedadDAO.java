package com.registerLab.DAO;

import java.sql.Date;
import java.util.ArrayList;

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
		
		public ArrayList<Novedad> getNovedades();

		public ArrayList<Novedad> novedadesEquipo(int equipo);

		public ArrayList<Novedad> getNovedadesElemento(int elemento);

		public ArrayList<Novedad> getNovedades(int elemento, int equipo);

		public void agregarNovedadSinElemento(String razon, String justificacion, int equipo, int usuario);
}
