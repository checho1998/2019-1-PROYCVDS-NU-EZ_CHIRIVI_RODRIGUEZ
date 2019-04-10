package com.registerLab.mappers;

import java.sql.Date;

import org.apache.ibatis.annotations.Param;

import com.registerLab.entities.Equipo;

public interface EquipoMapper {
	public Equipo getEquipo(@Param("Id") int id);
	
	public void insertarEquipo(@Param("idE")int id,
			@Param("feiniact")Date fechainicioactividad,
			@Param("fefinact")Date fechafinactividad,
			@Param("feadq")Date fechaadquisicion,
			@Param("idL")int laboratorio);
}
