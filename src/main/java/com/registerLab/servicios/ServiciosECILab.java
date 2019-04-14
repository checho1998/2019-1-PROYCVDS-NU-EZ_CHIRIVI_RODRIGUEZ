package com.registerLab.servicios;

import java.sql.Date;
import java.util.List;

import com.registerLab.ECILabException;
import com.registerLab.entities.Elemento;
import com.registerLab.entities.Equipo;
import com.registerLab.entities.Usuario;

public interface ServiciosECILab {
	
	public Usuario getUsuario(String correo);
	
	public void insertarEquipoSinLaboratorio(int id,Date fechainicioactividad,Date fechafinactividad,Date fechaadquisicion) throws ECILabException;
	
	public Equipo getEquipo(int id);
	
	public Elemento getElemento(int id);
	
	public List<Elemento> getElementos();
	
	public void AgregarElemento(int id, String categoria, String fabricante, String referencia, Date fechaAdquisicion, Date fechaInicioActividad, Date fechaFinActivida) throws ECILabException; 
	
}
