package com.registerLab.mappers;

import org.apache.ibatis.annotations.Param;

import com.registerLab.entities.Elemento;
import com.registerLab.entities.Equipo;

public interface ElementoMapper {
	
	public Elemento getElemento(@Param("Id") int id);
	
}
