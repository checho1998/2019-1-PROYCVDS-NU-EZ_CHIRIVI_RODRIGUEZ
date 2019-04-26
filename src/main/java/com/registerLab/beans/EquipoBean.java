package com.registerLab.beans;


import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.apache.shiro.SecurityUtils;

import com.google.inject.Inject;
import com.google.inject.Injector;
import com.registerLab.ECILabException;
import com.registerLab.entities.Elemento;
import com.registerLab.servicios.ServiciosECILabImpl;



@ManagedBean(name="equiBean")
@SessionScoped

public class EquipoBean  extends BaseBeanRegisterLab {
	
	@Inject
	private ServiciosECILabImpl servicios;
	private Injector injector;
	private int id;
	private java.util.Date fechaFin;
	private java.util.Date fechaAdquisicion;
	private java.util.Date fechaInicioActividad;
	private int idElemento;
	private int idAnt;
	private String descripcion;
	private ArrayList<Elemento> elementos;
	
	
	public EquipoBean() {
		injector = super.getInjector();
		servicios = injector.getInstance(ServiciosECILabImpl.class);
	}
	
	public void setId(int id) {
		this.id = id;
	}
	public void setfechaInicioActividad(java.util.Date fechaInicioActividad) {
		this.fechaInicioActividad = fechaInicioActividad;
	}
	public void setfechaFinActividad(java.util.Date fechaFinActividad) {
		this.fechaFin = fechaFinActividad;
	}
	public void setfechaAdquisicion(java.util.Date fechaAdquisicion) {
		this.fechaAdquisicion=fechaAdquisicion;
	}
	public void setElementos(ArrayList<Elemento> elementos) {
		this.elementos = elementos;
	}
	
	public void setidAnt(int id) {
		this.idAnt=id;
	}
	
	public void setidElemento(int id) {
		this.idElemento = id;
	}
	
	public int getidElemento() {
		return idElemento;
	}
	
	public int getidAnt() {
		return idAnt;
	}
	
	
	public int getId() {
		return id;
	}
	public java.util.Date getfechaInicioActividad() {
		return fechaInicioActividad;
	}
	public java.util.Date getfechaFinActividad(){
		return fechaFin;
	}
	public java.util.Date getFechaAdquisicion() {
		return fechaAdquisicion;
	}
	public ArrayList<Elemento> getelementos() {
		return elementos;
	}
	
	public void registrarEquipo() {
		FacesContext context = FacesContext.getCurrentInstance();
		try{
			Date d=null; 
			Date da=null;
			if(fechaAdquisicion!=null) d= new Date(fechaAdquisicion.getTime());
			if(fechaInicioActividad!=null) da= new Date(fechaInicioActividad.getTime());
			servicios.insertarEquipoSinLaboratorio(id, da, null, d);
			context.addMessage(null, new FacesMessage("Succesfull","Equipo Insertado.") );
			
		}catch(Exception e){
			context.addMessage(null, new FacesMessage("Error","No es posible registrar el equipo") );			
		}
	}
	public void asociarElemento() {
			elementos.add(servicios.getElemento(idElemento));
			FacesContext context = FacesContext.getCurrentInstance();
			try {
				Date actual=null;
				java.util.Date fechaActual = new java.util.Date(); 		
				actual=new Date (fechaActual.getTime());
				int ultimo = servicios.getUltimaNovedad();
				servicios.asociarElemento(idElemento, id,servicios.getUsuario(SecurityUtils.getSubject().getPrincipal().toString()).getId());
				servicios.AgregarNovedad("Se realiza una nueva asociacion al elemento con su respectivo equipo","Nueva asociacion de elemento", id, idElemento,servicios.getUsuario(SecurityUtils.getSubject().getPrincipal().toString()).getId());
				context.addMessage(null, new FacesMessage("Succesfull","elemento asociado.") );
				
				
			} catch (ECILabException e) {
				context.addMessage(null, new FacesMessage("error","No se pudo asociar el elemento verifique la informacion ingresada" ));
			}		
	}
	
	public void modificarAsociarElemento() {
		FacesContext context = FacesContext.getCurrentInstance();
		try {
		Date actual=null;
		java.util.Date fechaActual = new java.util.Date(); 		
		actual=new Date (fechaActual.getTime());
		int ultimo = servicios.getUltimaNovedad();
		servicios.AgregarNovedad(descripcion, "Cambio de asociacion del elemento a otro equipo", id, idElemento,servicios.getUsuario(SecurityUtils.getSubject().getPrincipal().toString()).getId());
		servicios.asociarElemento(idElemento, id);
		context.addMessage(null, new FacesMessage("Succesfull","Asociacion modificada.") );
		}
		catch(Exception e) {
			context.addMessage(null, new FacesMessage("error","No se puede modificar la asociacion verifique la informacion ingresada") );
		}
	}
	
	
	

}