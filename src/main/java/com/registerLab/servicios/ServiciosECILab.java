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
	
	public void AgregarNovedad(String descripcion,String justificacion,int idEquipo,int idElemento,int usuario) throws ECILabException;
	
	public void AgregarElemento(int id, String categoria, String fabricante, String referencia, Date fechaAdquisicion, Date fechaInicioActividad, Date fechaFinActivida) throws ECILabException; 
	
	public int getUltimaNovedad();
	
	public void asociarElemento(int idElemento, int IdEquipoN,int usuario) throws ECILabException;
	
	public List<Equipo> getEquipos();
	
	public void asociarElemento(int idElemento, int IdEquipoN) throws ECILabException;

	public void registrarUsuario(int carnet,String nombre,String apellido,String correo,String rol,String contra);
	
}
