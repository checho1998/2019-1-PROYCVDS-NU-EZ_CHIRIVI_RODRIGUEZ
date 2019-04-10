package com.registerLab.servicios;

import com.google.inject.Inject;
import com.registerLab.DAO.ElementoDAO;
import com.registerLab.DAO.EquipoDAO;
import com.registerLab.DAO.LaboratorioDAO;
import com.registerLab.DAO.NovedadDAO;
import com.registerLab.DAO.UsuarioDAO;
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
}
