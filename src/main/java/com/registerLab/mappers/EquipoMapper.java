package com.registerLab.mappers;

import java.sql.Date;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.registerLab.entities.Elemento;

import com.registerLab.entities.Equipo;

public interface EquipoMapper {
	public Equipo getEquipo(@Param("id") int id);
	
	public void insertarEquipoSinLaboratorio(@Param("idE")int id,
			@Param("feiniact")Date fechainicioactividad,
			@Param("fefinact")Date fechafinactividad,
			@Param("feadq")Date fechaadquisicion);

	public void asociarElemento(@Param("elemento")int idElemento,@Param("equipo") int idEquipoN);
	
	public List<Equipo> getEquipos();
	
	public boolean equipoPoseElemento(int elemento);
}
