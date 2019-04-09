package com.registerLab.entities;

import java.sql.Date;

public class Equipo {
	private int id;
	private Date fechaInicioActividad;
	private Date fechaFinActividad;
	private Date fechaAdquisicion;
	private int laboratorio;
	
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
	
	public int getLaboratorio() {
		return laboratorio;
	}
	
	public void setlaboratorio(int laboratorio) {
		this.laboratorio = laboratorio;
	}
	
}