package com.registerLab.servicios;

import java.sql.Date;

import com.google.inject.Inject;
import com.registerLab.ECILabException;
import com.registerLab.DAO.ElementoDAO;
import com.registerLab.DAO.EquipoDAO;
import com.registerLab.DAO.LaboratorioDAO;
import com.registerLab.DAO.NovedadDAO;
import com.registerLab.DAO.UsuarioDAO;
import com.registerLab.entities.Elemento;
import com.registerLab.entities.Equipo;
import com.registerLab.entities.Usuario;

public class ServiciosECILabImpl implements ServiciosECILab{
	@Inject
	private UsuarioDAO usuario;
	@Inject
	private EquipoDAO equipo;
	@Inject
	private LaboratorioDAO laboratorio;
	@Inject
	private NovedadDAO novedad;
	@Inject
	private ElementoDAO elemento;
	public Usuario getUsuario(String correo) {
		return usuario.getUsuario(correo);
	}
	public void insertarEquipoSinLaboratorio(int id,Date fechainicioactividad,Date fechafinactividad,Date fechaadquisicion) throws ECILabException {
		equipo.insertarEquipoSinLaboratorio(id, fechainicioactividad, fechafinactividad, fechaadquisicion);
	}
	public Equipo getEquipo(int id) {
		return equipo.getEquipo(id);
	}
	public Elemento getElemento(int id) {
		return elemento.getElemento(id);
	}
	public void AgregarElemento(int id, String categoria, String fabricante, String referencia, Date fechaAdquisicion, Date fechaInicioActividad, Date fechaFinActivida) throws ECILabException {
		elemento.AgregarElemento(id, categoria, fabricante, referencia, fechaAdquisicion, fechaInicioActividad, fechaFinActivida);
	}
}
