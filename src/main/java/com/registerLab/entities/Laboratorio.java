package com.registerLab.entities;

import java.sql.Date;
import java.util.ArrayList;
public class Laboratorio {
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
	
	public int getCapacidad() {
		return capacidad;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public Date getFechaCierre() {
		return fechaCierre;
	}
	
	public void setFechaAdquisicion(Date fechaCierre) {
		this.fechaCierre = fechaCierre;
	}
	
	public void setEquipos(ArrayList<Equipo> equipos){
		this.equipos = equipos;
	}
	
}
