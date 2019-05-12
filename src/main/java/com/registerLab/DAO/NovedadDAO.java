package com.registerLab.DAO;

import java.sql.Date;
import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import com.registerLab.ECILabException;
import com.registerLab.entities.Novedad;

public interface NovedadDAO {
	
		Novedad getNovedad(int id)throws ECILabException;
		int getUltimaNovedad();
		
		void agregarNovedad(
		String descripcion,
		String justificacion,
		int idEquipo,
		int idElemento,
		int usuario) throws ECILabException;

		void registrarNovedadSinEquipo(String descripcion, String justificacion, int elemento, int usuario);
		
		ArrayList<Novedad> getNovedades();

		ArrayList<Novedad> novedadesEquipo(int equipo);

<<<<<<< HEAD
		ArrayList<Novedad> getNovedadesElemento(int elemento);
		
		ArrayList<Novedad> getNovedadesLabEqui(int labo);
=======
		public ArrayList<Novedad> getNovedadesElemento(int elemento);

		public ArrayList<Novedad> getNovedades(int elemento, int equipo);

		public void agregarNovedadSinElemento(String razon, String justificacion, int equipo, int usuario);
>>>>>>> 3afe81c3387b4860d9a31e5c7e6983099b03d642
}
