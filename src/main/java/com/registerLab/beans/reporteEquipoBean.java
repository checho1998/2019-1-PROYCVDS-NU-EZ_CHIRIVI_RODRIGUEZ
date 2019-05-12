package com.registerLab.beans;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import com.google.inject.Injector;
import com.registerLab.entities.Elemento;
import com.registerLab.entities.Equipo;
import com.registerLab.servicios.ServiciosECILabImpl;

@ManagedBean(name="regElmBean")
@RequestScoped
public class reporteEquipoBean extends BaseBeanRegisterLab {
	
	private Injector injector;
	private ServiciosECILabImpl servicios;
	private int idEquipo;
	private String activo;
	
	
	public reporteEquipoBean() {
		injector = super.getInjector();
		servicios = injector.getInstance(ServiciosECILabImpl.class);
	}
	
	public List<Equipo> getTotalEquipos(){
		try{
			List<Equipo> el = servicios.getEquipos();
			return el;
		}catch(Exception e){
			return null;
		}
	}
	
	public Equipo getEquipo() {
		return servicios.getEquipo(idEquipo);
	}
	
	public int getIdEquipo() {
		return idEquipo;
	}
	
	public void setIdEquipo(int idEquipo) {
		this.idEquipo = idEquipo;
	}
	
	public String EquipoActivo() {
	
		if (getEquipo().getFechaFinActividad() == null) {
			this.activo = "Activo";
			
		}
		else {
			this.activo = "Inactivo"; 
		}
	
		return activo;
	
	}
	
	
	
	
			
}
	

