package com.registerLab.servicios;

import com.google.inject.Inject;
import com.registerLab.DAO.UsuarioDAO;
import com.registerLab.entities.Usuario;

public class ServiciosECILabImpl implements ServiciosECILab{
	@Inject
	private UsuarioDAO usuario;
	public Usuario getUsuario(String correo) {
		return usuario.getUsuario(correo);
	}
}
