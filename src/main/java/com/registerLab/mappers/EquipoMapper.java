package com.registerLab.mappers;

import java.sql.Date;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import com.registerLab.entities.Elemento;

import com.registerLab.entities.Equipo;

public interface EquipoMapper {
	public Equipo getEquipo(@Param("id") int id);
	
	public void insertarEquipoSinLaboratorio(@Param("idE")int id,
			@Param("feiniact")java.util.Date fechainicioactividad,
			@Param("fefinact")java.util.Date fechafinactividad,
			@Param("feadq")java.util.Date fechaadquisicion);
	
	public void asociarElemento(@Param("Elementos") ArrayList<Elemento> elementos,@Param("idequi") int idequipo);
}
