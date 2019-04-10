package com.registerLab.myBatisDAO;

import com.google.inject.Inject;
import com.registerLab.DAO.NovedadDAO;
import com.registerLab.mappers.NovedadMapper;

public class MyBatisNovedadDAO implements NovedadDAO{
	@Inject
	private NovedadMapper mapper;
}
