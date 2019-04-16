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
		this.fechaFin = fechaFinActividad;
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
			if(fechaAdquisicion!=null) d= new Date(this.getFechaAdquisicion().getTime());
			if(fechaInicioActividad!=null) da= new Date(this.getfechaInicioActividad().getTime());
			servicios.insertarEquipoSinLaboratorio(this.getId(), da, null, d);
			context.addMessage(null, new FacesMessage("Succesfull","Equipo Insertado.") );
			
		}catch(Exception e){
			
			context.addMessage(null, new FacesMessage("Error","No es posible registrar el equipo") );			
		}
	}
	public void asociarElemento() {
			elementos.add(servicios.getElemento(idElemento));
			FacesContext context = FacesContext.getCurrentInstance();
			try {
				
				servicios.asociarElemento(elementos, id);
				servicios.getElemento(id);
				context.addMessage(null, new FacesMessage("Succesfull","elemento asociado.") );
				
				
			} catch (ECILabException e) {
				context.addMessage(null, new FacesMessage("error",e.getMessage()) );
			}
			
		
	}
	
	

}
