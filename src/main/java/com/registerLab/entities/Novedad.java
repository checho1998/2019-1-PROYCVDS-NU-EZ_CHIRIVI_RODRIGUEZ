package com.registerLab.entities;

import java.sql.Date;

public class Novedad {
	private int id;
	private Date fechaNovedad;
	private String descripcion;
	private String justificacion;
	public Novedad() {
		
	}
	public void setId(int id) {
		this.id=id;
	}
	public void setFechaNovedad(Date fecha) {
		this.fechaNovedad = fecha;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public void setJustificacion(String justificacion) {
		this.justificacion = justificacion;
	}
	public int getId() {
		return id;
	}
	public Date getFechaNovedad() {
		return fechaNovedad;
	}
	public String getJustificacion() {
		return justificacion;
	}
	public String getDescripcion() {
		return descripcion;
	}
}
