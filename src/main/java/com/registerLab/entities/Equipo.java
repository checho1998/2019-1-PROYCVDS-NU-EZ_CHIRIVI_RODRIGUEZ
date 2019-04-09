package com.registerLab.entities;

import java.sql.Date;

public class Equipo {
	private int id;
	private Date fechaInicioActividad;
	private Date fechaFinActividad;
	private Date fechaAdquisicion;
	private ArrayList<Elemento> elementos;
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getId() {
		return id;
	}
	
	public Date getFechaInicioActividad() {
		return fechaInicioActividad;
	}
	
	public void setFechaInicioActividad(Date fechaInicioActividad) {
		this.fechaInicioActividad = fechaInicioActividad;
	}
	
	public Date getFechaFinActividad() {
		return fechaFinActividad;
	}
	
	public Date getFechaAdquisicion() {
		return fechaAdquisicion;
	}
	
	public void setFechaAdquisicion(Date fechaAdquisicion) {
		this.fechaAdquisicion = fechaAdquisicion;
	}
	
	public void setElemmentos(ArrayList<Elemento> elementos){
		this.elementos = elementos;
	}
	public ArrayList<Elemento> getElementos(){
		return elementos;
	}
	
}
