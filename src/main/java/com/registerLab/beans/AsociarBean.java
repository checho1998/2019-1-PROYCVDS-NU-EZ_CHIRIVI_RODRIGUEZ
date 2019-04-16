package com.registerLab.beans;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.google.inject.Injector;
import com.registerLab.ECILabException;
import com.registerLab.entities.Elemento;
import com.registerLab.entities.Equipo;
import com.registerLab.servicios.ServiciosECILabImpl;

@ManagedBean(name="asoBean")
@SessionScoped
public class AsociarBean extends BaseBeanRegisterLab{
	private int idEquipo;
	private int idElemento;
	private Injector injector;
	private ServiciosECILabImpl servicios;
	public AsociarBean() {
		injector = super.getInjector();
		servicios = injector.getInstance(ServiciosECILabImpl.class);
	}
	public void setIdEquipo(int id) {
		this.idEquipo = id;
	}
	public int getIdEquipo() {
		return idEquipo;
	}
	public void setIdElemento(int id) {
		idElemento = id;
	}
	public int getIdElemento() {
		return idElemento;
	}
	public void asociarElemento() {
		try {
			servicios.asociarElemento(idElemento, idEquipo);
		} catch (ECILabException e) {
			e.printStackTrace();
		}
	}
	public List<Equipo> getEquipos(){
		return servicios.getEquipos();
	}
}
