package com.registerLab.mappers;

import java.sql.Date;

import org.apache.ibatis.annotations.Param;

import com.registerLab.entities.Elemento;

public interface ElementoMapper {
	
	public Elemento getElemento(@Param("ElemId") int id);
	
	public void AgregarElemento(@Param("id") int id
			,@Param("cat") String categoria
			,@Param("fab") String fabricante
			,@Param("ref") String referencia
			,@Param("fecAq") Date fechaAdquisicion
			,@Param("fecIn") Date fechaInicioActividad
			,@Param("fecFin") Date fechaFinActividad);
}
