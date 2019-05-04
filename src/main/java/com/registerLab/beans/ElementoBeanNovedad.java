package com.registerLab.beans;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.google.inject.Injector;
import com.registerLab.entities.Elemento;
import com.registerLab.entities.Novedad;
import com.registerLab.servicios.ServiciosECILabImpl;

@ManagedBean(name="ENovBean")
@SessionScoped
public class ElementoBeanNovedad extends BaseBeanRegisterLab{
	private int elemento;
	private Injector injector;
	private ServiciosECILabImpl servicios;
	public ElementoBeanNovedad() {
		injector = super.getInjector();
		servicios = injector.getInstance(ServiciosECILabImpl.class);
	}
	public void setElemento(int elemento) {
		this.elemento = elemento;
	}
	public int getElemento() {
		return elemento;
	}
	public Elemento get() {
		return servicios.getElemento(elemento);
	}
	public ArrayList<Novedad> getNovedad(){
		return servicios.getNovedadesElemento(elemento);
	}

}
