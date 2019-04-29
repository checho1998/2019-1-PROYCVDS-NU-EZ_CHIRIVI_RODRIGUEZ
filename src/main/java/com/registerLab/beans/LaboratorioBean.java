package com.registerLab.beans;

import java.sql.Date;
import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.registerLab.entities.Equipo;

@ManagedBean(name="laboBean")
@SessionScoped

public class LaboratorioBean extends BaseBeanRegisterLab  {
	private int id;
	private String nombre;
	private int capacidad;
	private Date fechaCierre;
	private ArrayList<Equipo> equipos;
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getId() {
		return id;
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
}
