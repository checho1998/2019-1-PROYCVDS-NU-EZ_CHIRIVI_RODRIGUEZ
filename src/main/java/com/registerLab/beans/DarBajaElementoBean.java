package com.registerLab.beans;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.google.inject.Injector;
import com.registerLab.ECILabException;
import com.registerLab.servicios.ServiciosECILabImpl;

@ManagedBean(name="elemBajaBean")
@SessionScoped
public class DarBajaElementoBean extends BaseBeanRegisterLab{
	private Injector injector;
	private ServiciosECILabImpl servicios;
	private int elemento;
	public DarBajaElementoBean() {
		injector = super.getInjector();
		servicios = injector.getInstance(ServiciosECILabImpl.class);
	}
	public void setElemento(int elemento) {
		this.elemento = elemento;
	}
	public int getElemento() {
		return elemento;
	}
	public void darBaja() {
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			servicios.darBajaElemento(elemento);
			context.addMessage(null, new FacesMessage("Succesfull","El elemento a sido dado de baja."));
		}catch(ECILabException e) {
			context.addMessage(null, new FacesMessage("error",e.getMessage()));

			
		}
	}
	
}
