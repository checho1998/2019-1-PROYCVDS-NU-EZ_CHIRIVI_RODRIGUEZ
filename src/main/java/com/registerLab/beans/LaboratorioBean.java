package com.registerLab.beans;

import java.sql.Date;
import java.util.ArrayList;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.apache.shiro.SecurityUtils;

import com.google.inject.Inject;
import com.google.inject.Injector;
import com.registerLab.ECILabException;
import com.registerLab.entities.Elemento;
import com.registerLab.entities.Equipo;
import com.registerLab.entities.Laboratorio;
import com.registerLab.servicios.ServiciosECILabImpl;

@ManagedBean(name="laboBean")
@SessionScoped

public class LaboratorioBean extends BaseBeanRegisterLab  {
	@Inject
	private ServiciosECILabImpl servicios;
	private Injector injector;
	private int id;
	private int capacidad;
	private String nombre;
	private Date fechaCierre;	
	private ArrayList<Equipo> equipos;
	
	public LaboratorioBean() {
		injector = super.getInjector();
		servicios = injector.getInstance(ServiciosECILabImpl.class);
		equipos = new ArrayList<Equipo>() {
			@Override
			public boolean add(Equipo e) {
				if(e.getFechaFinActividad()==null || servicios.equipoAsociadoaLaboratorio(e.getId())) {
					ArrayList<Equipo> toRemove = new ArrayList<>();
					for(int i=0;i<size();i++) {
						if(get(i).getId() == e.getId()) toRemove.add(get(i));
					}
					for(Equipo el:toRemove) {
						remove(el);
					}
					return super.add(e);
					
				}
				else {
					FacesContext context = FacesContext.getCurrentInstance();
					context.addMessage(null, new FacesMessage("Succesfull","No fue posible añadir el equipo seleccionado") );
					return false;
				}
			} 
		};
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getId() {
		return id;
	}
	
	public void add(Equipo e) {
		equipos.add(e);
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setfechaCierre(Date fechaCierre) {
		this.fechaCierre = fechaCierre;		
	}
	
	public Date getfechaCierre() {
		return fechaCierre;
	}
	
	public ArrayList<Equipo> getEquipos() {
		return equipos;
	}
	
	public ArrayList<Equipo> getEquipos1(){
		return servicios.getEquipos();
	}

	public void setEquipos(ArrayList<Equipo> equipos) {
		this.equipos = equipos;
	}
	
	public void setEquipos1(ArrayList<Equipo> equipos){
		this.equipos = equipos;
	}

	public int getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}
	
	public void agregarLaboratorio() { 
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			if(equipos.size() > getCapacidad()) throw new ECILabException("La cantidad de equipos exceden el limite la capacidad del laboratorio");
			servicios.agregarLaboratorio(id, nombre, capacidad, null);
			for(Equipo e:equipos) {
				servicios.asociarEquipo(e.getId(), id, servicios.getUsuario(SecurityUtils.getSubject().getPrincipal().toString()).getId());
			}
			equipos.clear();
	        context.addMessage(null, new FacesMessage("Succesfull","Laboratorio registrado.") );
		}catch(ECILabException e) {
			context.addMessage(null, new FacesMessage("Error",e.getMessage()));
		}
	}
	public Laboratorio getLaboratorio() {
		return servicios.getLaboratorio(id);
	}
}
