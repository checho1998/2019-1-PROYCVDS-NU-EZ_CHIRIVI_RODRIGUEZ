package com.registerLab.servicios;


import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.google.inject.Inject;
import com.registerLab.ECILabException;
import com.registerLab.DAO.ElementoDAO;
import com.registerLab.DAO.EquipoDAO;
import com.registerLab.DAO.LaboratorioDAO;
import com.registerLab.DAO.NovedadDAO;
import com.registerLab.DAO.UsuarioDAO;
import com.registerLab.entities.Elemento;
import com.registerLab.entities.Equipo;
import com.registerLab.entities.Novedad;
import com.registerLab.entities.Usuario;

public  class ServiciosECILabImpl implements ServiciosECILab{
	@Inject
	private UsuarioDAO usuario;
	@Inject
	private EquipoDAO equipo;
	@Inject
	private LaboratorioDAO laboratorio;
	@Inject
	private NovedadDAO novedad;
	@Inject
	private ElementoDAO elemento;
	
	public Usuario getUsuario(String correo) {
		return usuario.getUsuario(correo);
	}
	
	public void insertarEquipoSinLaboratorio(int id,Date fechaInicioActividad,Date fechafinactividad,Date fechaAdquisicion) throws ECILabException {
		equipo.insertarEquipoSinLaboratorio(id, fechaInicioActividad, fechafinactividad, fechaAdquisicion);
	}
	
	public Equipo getEquipo(int id) {
		return equipo.getEquipo(id);
	}
	
	public Elemento getElemento(int id) {
		return elemento.getElemento(id);
	}
	
	public List<Elemento> getElementos(){
		return elemento.consultarElementos();
	}
	
	public void AgregarElemento(int id, String categoria, String fabricante, String referencia, Date fechaAdquisicion, Date fechaInicioActividad, Date fechaFinActivida) throws ECILabException {
		elemento.AgregarElemento(id, categoria, fabricante, referencia, fechaAdquisicion, fechaInicioActividad, fechaFinActivida);
	}
	
	
	public void AgregarNovedad(int id,Date fechaNovedad,String descripcion,String justificacion,int idEquipo,int idElemento) throws ECILabException {
		
		novedad.agregarNovedad(id, fechaNovedad, descripcion, justificacion, idEquipo, idElemento);
	}

	@Override
	public Novedad getNovedad(int id) throws ECILabException  {
		return novedad.getNovedad(id);
	}
	
	@Override
	public int getUltimaNovedad() {
		return novedad.getUltimaNovedad();
	}
	
	@Override
	public void asociarElemento(int idElemento, int IdEquipoN) throws ECILabException {
		Elemento e = getElemento(idElemento);
		if(e==null) throw new ECILabException("No existe el elemento a vincular.");
		if(e.getFechaFinActividad()!=null) throw new ECILabException("El elemento a sido dado de baja, este no puede ser vinculado a ningun equipo.");
		if(equipo.getEquipo(IdEquipoN)==null) throw new ECILabException("No existe este equipo.");
		elemento.desvincularElementos(e.getCategoria(),equipo.getEquipo(IdEquipoN).getId());
		equipo.asociarElemento(idElemento, IdEquipoN);
	}

	@Override
	public List<Equipo> getEquipos() {
		return equipo.getEquipos();
	}

	
	
	
}
