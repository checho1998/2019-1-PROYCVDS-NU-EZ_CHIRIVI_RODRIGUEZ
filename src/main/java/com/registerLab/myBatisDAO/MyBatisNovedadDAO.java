package com.registerLab.myBatisDAO;

import java.sql.Date;

import com.google.inject.Inject;
import com.registerLab.ECILabException;
import com.registerLab.DAO.NovedadDAO;
import com.registerLab.entities.Novedad;
import com.registerLab.mappers.NovedadMapper;

public class MyBatisNovedadDAO implements NovedadDAO{
	@Inject
	private NovedadMapper mapper;
	
	@Override
	public Novedad getNovedad(int id) {
		return mapper.getNovedad(id);		
	}
	
	@Override
	public void agregarNovedad(int id,Date fechaNovedad,String descripcion,String justificacion,int idEquipo, int idElemento) throws ECILabException {
		if(justificacion =="" || justificacion== null) throw new ECILabException("No se puede agregar, debido a que no hay justificacion");
		if(getNovedad(id) != null ) throw new ECILabException("Ya existe una novedad con este codigo");
		if(justificacion =="" || justificacion== null) throw new ECILabException("No se puede agregar, debido a que no hay descripcion");
		mapper.agregarNovedad(id, fechaNovedad, descripcion, justificacion,idEquipo,idElemento);
		
	}
	
	@Override
	public int getUltimaNovedad() {
		return mapper.getUltimaNovedad();
	}
	
}
