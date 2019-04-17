package com.registerLab.mappers;

import java.sql.Date;

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
}
