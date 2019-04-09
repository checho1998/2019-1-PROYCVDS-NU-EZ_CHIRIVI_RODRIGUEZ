package com.registerLab.mappers;

import org.apache.ibatis.annotations.Param;

import com.registerLab.entities.Usuario;

public interface UsuarioMapper {
	public Usuario getUsuario(@Param("Correo") String correo);
}
