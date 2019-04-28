package com.registerLab.beans;

import javax.faces.application.FacesMessage;

import javax.faces.bean.ManagedBean;

import javax.faces.bean.SessionScoped;

import javax.faces.context.FacesContext;

import org.apache.shiro.SecurityUtils;

import com.google.inject.Injector;

import com.registerLab.ECILabException;
import com.registerLab.entities.Equipo;
import com.registerLab.servicios.ServiciosECILabImpl;

@ManagedBean(name="equiBajaBean")
@SessionScoped
public class DarBajaEquipoBean extends BaseBeanRegisterLab{
	private Injector injector;
	private ServiciosECILabImpl servicios;
	private int equipo;
	
	public DarBajaEquipoBean() {
		injector = super.getInjector();
		servicios = injector.getInstance(ServiciosECILabImpl.class);
	}
	
	public void setEquipo(int equipo) {
		this.equipo = equipo;
	}
	
	public int getEquipo() {
		return equipo;
	}
	
	public void darBaja(Equipo eq) {
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			servicios.darBajaEquipo(eq.getId(),servicios.getUsuario(SecurityUtils.getSubject().getPrincipal().toString()).getId());
			context.addMessage(null, new FacesMessage("Succesfull","El equipo ha sido dado de baja."));
		}catch(ECILabException e) {
			System.out.println(e.getMessage());
			context.addMessage(null, new FacesMessage("error",e.getMessage()));

			
		}
	}
	
	
}
