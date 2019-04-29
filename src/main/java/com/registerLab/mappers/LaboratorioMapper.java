package com.registerLab.mappers;

import java.sql.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.registerLab.entities.Laboratorio;
import com.registerLab.entities.Usuario;

public interface LaboratorioMapper {
	
	public Laboratorio getLaboratorio(@Param("Id") int id);
	
	public void agregarLaboratorio(@Param("Id") int id,@Param("Nom") String nombre,@Param("capacidad") int capacidad,@Param("fecha") Date fechacierre);
	
	public void asociarEquipo(@Param("equipo")int idEquipo,@Param("laboratorio") int idLaboratorioN);
<<<<<<< HEAD
	
	public List<Laboratorio> getLaboratorios();
	
	
	
=======

	public List<Laboratorio> getLaboratorios();

>>>>>>> b792b526ce3b7553934d5447b007da8d27932e5a
}