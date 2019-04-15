package com.registerLab.beans;


import com.google.inject.Inject;
import com.google.inject.Injector;
import com.registerLab.ECILabException;
import com.registerLab.entities.Elemento;
import com.registerLab.servicios.ServiciosECILabImpl;
import java.sql.Date;
import java.util.ArrayList;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;



@ManagedBean(name="equiBean")
@SessionScoped

public class EquipoBean  extends BaseBeanRegisterLab  {
	
	@Inject
	private ServiciosECILabImpl servicios;
	private Injector injector;
	private int id;
	private java.util.Date fechaInicioActividad;
	private java.util.Date fechaFinActividad;
	private java.util.Date fechaAdquisicion;
	private ArrayList<Elemento> elementos;
	
	
	public EquipoBean() {
		injector = super.getInjector();
		servicios = injector.getInstance(ServiciosECILabImpl.class);
	}
	
	public void setId(int id) {
		this.id = id;
	}
	public void setfechainicioactividad(java.util.Date fechaInicioActividad) {
		this.fechaInicioActividad = fechaInicioActividad;
	}
	public void setfechaFinActividad(java.util.Date fechaFinActividad) {
		this.fechaFinActividad = fechaFinActividad;
	}
	public void setfechaAdquisicion(java.util.Date fechaAdquisicion) {
		this.fechaAdquisicion=fechaAdquisicion;
	}
	public void setElementos(ArrayList<Elemento> elementos) {
		this.elementos = elementos;
	}
	public int getId() {
		return id;
	}
	public java.util.Date getfechaInicioActividad() {
		return fechaInicioActividad;
	}
	public java.util.Date getfechaFinActividad(){
		return fechaFinActividad;
	}
	public java.util.Date getFechaAdquisicion() {
		return fechaAdquisicion;
	}
	public ArrayList<Elemento> getelementos() {
		return elementos;
	}
	
	public void registrarEquipo() {
		try{
			
			servicios.insertarEquipoSinLaboratorio(id, fechaInicioActividad, null, fechaAdquisicion);
			
		}catch(Exception e){
			
			FacesContext context = FacesContext.getCurrentInstance();
	        context.addMessage(null, new FacesMessage("Error","No es posible registrar el equipo") );			
		}
	}
	public void asociarElemento(int id,int idEquipo) {
		try {
			elementos.add(servicios.getElemento(id));
			servicios.asociarElemento(elementos, idEquipo);
		}
		catch(Exception e) {
			FacesContext context = FacesContext.getCurrentInstance();
	        context.addMessage(null, new FacesMessage("Error","no es posible asociar el elemento debido a que no existe por favor registrelo") );
			
		}
	}
	
	

}
