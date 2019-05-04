package com.registerLab.servicios;


import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import org.apache.shiro.SecurityUtils;

import com.google.inject.Inject;
import com.registerLab.ECILabException;
import com.registerLab.DAO.ElementoDAO;
import com.registerLab.DAO.EquipoDAO;
import com.registerLab.DAO.LaboratorioDAO;
import com.registerLab.DAO.NovedadDAO;
import com.registerLab.DAO.UsuarioDAO;
import com.registerLab.entities.Elemento;
import com.registerLab.entities.Equipo;
import com.registerLab.entities.Laboratorio;
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
		if(equipo.getEquipo(idEquipo)==null) throw new ECILabException("No existe el equipo.");
		if(elemento.getElemento(idElemento)==null) throw new ECILabException("No existe el Elemento.");
		if(!equipoPosee(equipo.getEquipo(idEquipo),idElemento)) throw new ECILabException("Equipo y elemento no se encuentran vinculados");
		novedad.agregarNovedad(descripcion, justificacion, idEquipo, idElemento,usuario);
	}

	private boolean equipoPosee(Equipo equipo2, int idElemento) {
		for(Elemento e:equipo2.getElementos()) {
			if(e.getId()==idElemento) return true;
		}
		return false;
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
		if(elementoAsociadoaEquipo(idElemento)) throw new ECILabException("Este elemento ya se encuentra vinculado a otro equipo");
		if(e.getFechaFinActividad()!=null) throw new ECILabException("El elemento a sido dado de baja, este no puede ser vinculado a ningun equipo.");
		if(equipo.getEquipo(IdEquipoN)==null) throw new ECILabException("No existe este equipo.");
		elemento.desvincularElementos(e.getCategoria(),equipo.getEquipo(IdEquipoN).getId());
		equipo.asociarElemento(idElemento, IdEquipoN);
		novedad.agregarNovedad("Asociacion elemento","completar equipo", IdEquipoN, idElemento,usuario);
	}
	
	public void asociarElemento(int idElemento, int IdEquipoN) throws ECILabException {
		Elemento e = getElemento(idElemento);
		if(e==null) throw new ECILabException("No existe el elemento a vincular.");
		if(elementoAsociadoaEquipo(idElemento)) throw new ECILabException("Este elemento ya se encuentra vinculado a otro equipo");
		if(e.getFechaFinActividad()!=null) throw new ECILabException("El elemento a sido dado de baja, este no puede ser vinculado a ningun equipo.");
		Equipo eq =equipo.getEquipo(IdEquipoN); 
		if(eq==null) throw new ECILabException("No existe este equipo.");
		if(eq.getFechaFinActividad()!=null) throw new ECILabException("El equipo fue dado de baja, no se le pueden asociar elementos.");
		elemento.desvincularElementos(e.getCategoria(),equipo.getEquipo(IdEquipoN).getId());
		equipo.asociarElemento(idElemento, IdEquipoN);
	}
	
	public boolean elementoAsociadoaEquipo(int elemento) {
		return this.elemento.elementoAsociadoaEquipo(elemento);
	}

	@Override
	public void asociarEquipo(int idEquipo, int IdLaboratorioN,int usuario) throws ECILabException {
		Equipo e = getEquipo(idEquipo);
		if(e==null) throw new ECILabException("No existe el equipo a vincular.");
		if(e.getFechaFinActividad()!=null) throw new ECILabException("El equipo a sido dado de baja, este no puede ser vinculado a ningun laboratorio.");
		Laboratorio l = laboratorio.getLaboratorio(IdLaboratorioN); 
		if(l==null) throw new ECILabException("No existe este laboratorio.");
		if(l.getCapacidad()<=l.getEquipos().size()) throw new ECILabException("Se ha llenado la capacidad de esta laboratorio");
		if(l.getFechaCierre()!=null) throw new ECILabException("No se pueden asociar equipos a un laboratorio cerrado");
		equipo.desvincularEquipo(idEquipo);
		laboratorio.asociarEquipo(idEquipo,IdLaboratorioN);
		//novedad.agregarNovedad("Asociacion elemento","completar equipo", IdLaboratorioN, idEquipo,usuario);
	}
	
	public void asociarEquipo(int idEquipo, int IdLaboratorioN) throws ECILabException {
		Equipo e = getEquipo(idEquipo);
		if(e==null) throw new ECILabException("No existe el equipo a vincular.");
		if(e.getFechaFinActividad()!=null) throw new ECILabException("El equipo a sido dado de baja, este no puede ser vinculado a ningun laboratorio.");
		if(laboratorio.getLaboratorio(IdLaboratorioN) == null) throw new ECILabException("No existe este laboratorio.");
		equipo.desvincularEquipo(idEquipo);
		laboratorio.asociarEquipo(idEquipo,IdLaboratorioN);
	}
	
	

	@Override
	public ArrayList<Equipo> getEquipos() {
		return equipo.getEquipos();
	}
	
	@Override
	public List<Laboratorio> getLaboratorios() {
		return laboratorio.getLaboratorios();
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
		registrarNovedadSinEquipo("Dar de baja","Tiempo o daño",elemento,usuario);
		
	}
	
	@Override
	public void darBajaConEquipoAsociado(Elemento elemento, Equipo eq) {
		this.elemento.darBaja(elemento.getId());
		this.elemento.desvincularElementos(elemento.getCategoria(), eq.getId());
		registrarNovedadSinEquipo("Dar de baja","Tiempo o daño",elemento.getId(),getUsuario(SecurityUtils.getSubject().getPrincipal().toString()).getId());
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
		if(equi.getElementos().size() != 0) throw new ECILabException("Debe desasociar o dar de baja a todos los elementos.");
		laboratorio.desasociarEquipo(equipo);
		this.equipo.darBaja(equipo);
		
		
	}

	@Override
	public void desvincularElemento(Elemento e,Equipo eq){
		elemento.desvincularElementos(e.getCategoria(),eq.getId());
	}

	@Override
	public ArrayList<Novedad> getNovedades() {
		return novedad.getNovedades();
	}
	
	public ArrayList<Elemento> getElementos(String categoria) {
		return elemento.getElemento(categoria);
	}
	
	@Override
	public void agregarLaboratorio(int id, String nombre, int capacidad, Date fechacierre) throws ECILabException{
		if(capacidad<=0) throw new ECILabException("La capacidad del laboratorio no puede ser negativa o cero");
		laboratorio.agregarLaboratorio(id, nombre, capacidad, fechacierre);
	}
	
	public boolean equipoAsociadoaLaboratorio(int equipo) {
		return this.equipo.equipoAsociadoaLaboratorio(equipo);
	}

	public ArrayList<Elemento> getElementosActivos() {
		return elemento.getElementosActivos();
	}

	public Laboratorio getLaboratorio(int laboratorio) {
		return this.laboratorio.getLaboratorio(laboratorio);
	}

	@Override
	public void cerrarLaboratorio(int laboratorio) throws ECILabException {
		Laboratorio l = this.laboratorio.getLaboratorio(laboratorio);
		if(l==null) throw new ECILabException("No existe este laboratorio.");
		if(l.getFechaCierre()!=null) throw new ECILabException("El laboratorio ya se encuentra cerrado.");
		for(Equipo e:l.getEquipos()) {
			this.laboratorio.desasociarEquipo(e.getId());
		}
		this.laboratorio.cerrarLaboratorio(laboratorio);
		
		
	}

	public ArrayList<Equipo> getAllEquipos() {
		return equipo.getAllEquipos();
	}

	public ArrayList<Novedad> novedadesEquipo(int equipo) {
		return novedad.novedadesEquipo(equipo);
	}
}
