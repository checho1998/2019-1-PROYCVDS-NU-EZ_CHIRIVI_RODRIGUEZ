package com.registerLab.mappers;

import java.sql.Date;
import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import com.registerLab.entities.Novedad;

public interface NovedadMapper {
	
	public Novedad getNovedad(@Param("idNov") int id);
	
	public void agregarNovedad(
			@Param("desc") String descripcion,
			@Param("just") String justificacion,
			@Param("idEquipo") int idEquipo,
			@Param("idElem") int idElemento,
			@Param("usuario")int usuario);
	
	public int getUltimaNovedad();
	
	public ArrayList<Novedad> getNovedades();

	public void registrarNovedadSinEquipo(@Param("descripcion") String descripcion,@Param("justificacion") String justificacion,@Param("elemento") int elemento,@Param("usuario") int usuario);

	public ArrayList<Novedad> novedadesEquipo(@Param("Equipo")int equipo);

	public ArrayList<Novedad> getNovedadesElemento(@Param("elemento")int elemento);
<<<<<<< HEAD
	
	public ArrayList<Novedad> getNovedadesLabEqui(@Param("lab") int labo);
=======

	public ArrayList<Novedad> getNovedadesElementoEquipo(@Param("elemento")int elemento, @Param("equipo")int equipo);

	public void agregarNovedadSinElemento(@Param("razon") String razon,@Param("justificacion") String justificacion,@Param("equipo") int equipo,@Param("usuario") int usuario);
>>>>>>> 3afe81c3387b4860d9a31e5c7e6983099b03d642
}
