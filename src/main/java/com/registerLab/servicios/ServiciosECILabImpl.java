package com.registerLab.servicios;


import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

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
	
	
	public void AgregarNovedad(String descripcion,String justificacion,int idEquipo,int idElemento,int usuario) throws ECILabException {
		novedad.agregarNovedad(descripcion, justificacion, idEquipo, idElemento,usuario);
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
	public void asociarElemento(int idElemento, int IdEquipoN,int usuario) throws ECILabException {
		Elemento e = getElemento(idElemento);
		if(e==null) throw new ECILabException("No existe el elemento a vincular.");
		if(e.getFechaFinActividad()!=null) throw new ECILabException("El elemento a sido dado de baja, este no puede ser vinculado a ningun equipo.");
		if(equipo.getEquipo(IdEquipoN)==null) throw new ECILabException("No existe este equipo.");
		elemento.desvincularElementos(e.getCategoria(),equipo.getEquipo(IdEquipoN).getId());
		equipo.asociarElemento(idElemento, IdEquipoN);
		novedad.agregarNovedad("Asociacion elemento","completar equipo", IdEquipoN, idElemento,usuario);
	}
	
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

	@Override
	public void registrarUsuario(int carnet, String nombre, String apellido, String correo, String rol, String contra) {
		usuario.registrarUsuario(carnet,nombre,apellido,correo,rol,contra);
	}
	
	@Override
	public boolean equipoPoseElemento(int elemento) {
		return equipo.equipoPoseElemento(elemento);
	}
	
	@Override
	public void darBajaElemento(int elemento,int usuario) throws ECILabException {
		Elemento elm = this.elemento.getElemento(elemento);
		if(elm==null) throw new ECILabException("El elememento debe existir para poder eliminarlo");
		if(equipoPoseElemento(elemento)) throw new ECILabException("Este equipo debe no estar asociado a algun equipo");
		if(elm.getFechaFinActividad()!=null)  throw new ECILabException("Este elemento ya fue dado de baja.");
		
		this.elemento.darBaja(elemento);
		registrarNovedadSinEquipo("dar de baja","Tiempo o daño",elemento,usuario);
		
	}
	
	@Override
	public void registrarNovedadSinEquipo(String descripcion,String justificacion,int elemento,int usuario){
		novedad.registrarNovedadSinEquipo(descripcion,justificacion,elemento,usuario);
	}

	
	@Override
	public void darBajaEquipo(int equipo,int usuario) throws ECILabException {
		Equipo equi = this.equipo.getEquipo(equipo);
		if(equi==null) throw new ECILabException("El equipo debe existir para poder eliminarlo");
		if(equi.getFechaFinActividad()!=null)  throw new ECILabException("Este equipo ya fue dado de baja.");
		if(equi.getElementos().size() != 0) {
			for(Elemento e:equi.getElementos()) {
				int input = JOptionPane.showConfirmDialog(null, "Quiere dar de baja el elemento numero " + e.getId() + "?", 
						"Seleccione una opcion ",JOptionPane.YES_NO_CANCEL_OPTION);
				if (input == 1) {
					this.darBajaElemento(e.getId(), usuario);
				}
				else {
					elemento.desvincularElementos(e.getCategoria(),equi.getId());
				}
			}
		}
		
		this.equipo.darBaja(equipo);
		
		//novedad.re("Dado de baja", "Debido a un daño irreparable", equipo, usuario);
	}
	
}
