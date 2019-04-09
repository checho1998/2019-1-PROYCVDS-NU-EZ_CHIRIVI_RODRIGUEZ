package com.registerLab.mappers;

import org.apache.ibatis.annotations.Param;

import com.registerLab.entities.Equipo;

public interface EquipoMapper {
	public Equipo getEquipo(@Param("Id") int id);
}
