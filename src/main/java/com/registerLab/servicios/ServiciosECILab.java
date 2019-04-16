package com.registerLab.servicios;

import java.sql.Date;
import java.util.List;

import com.registerLab.ECILabException;
import com.registerLab.entities.Elemento;
import com.registerLab.entities.Equipo;
import com.registerLab.entities.Novedad;
import com.registerLab.entities.Usuario;

public interface ServiciosECILab {
	
	public Usuario getUsuario(String correo);
	
	public void insertarEquipoSinLaboratorio(int id,Date fechaInicioActividad,Date fechafinactividad,Date fechaAdquisicion) throws ECILabException;
	
	public Equipo getEquipo(int id);
	
	public Elemento getElemento(int id);
	
	public List<Elemento> getElementos();
	
	public Novedad getNovedad(int id) throws ECILabException;
	
	public void AgregarNovedad(int id,Date fechaNovedad,String descripcion,String justificacion,int idEquipo,int idElemento) throws ECILabException;
	
	public void AgregarElemento(int id, String categoria, String fabricante, String referencia, Date fechaAdquisicion, Date fechaInicioActividad, Date fechaFinActivida) throws ECILabException; 
	
	public int getUltimaNovedad();
	
	public void cambioAsociacionElemento(int idElemento, int IdEquipoN) throws ECILabException;
}
