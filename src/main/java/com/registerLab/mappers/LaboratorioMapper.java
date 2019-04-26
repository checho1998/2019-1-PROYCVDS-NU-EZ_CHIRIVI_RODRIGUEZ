package com.registerLab.mappers;

import org.apache.ibatis.annotations.Param;

import com.registerLab.entities.Laboratorio;
import com.registerLab.entities.Usuario;

public interface LaboratorioMapper {
	
	public Laboratorio getLaboratorio(@Param("Id") int id);
	
	public void asociarEquipo(@Param("equipo")int idEquipo,@Param("laboratorio") int idLaboratorioN);
}