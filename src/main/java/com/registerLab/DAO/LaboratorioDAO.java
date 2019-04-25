package com.registerLab.DAO ;

import com.registerLab.entities.Equipo;
import com.registerLab.entities.Laboratorio;

public interface LaboratorioDAO{

	Laboratorio getLaboratorio(int id);

	void asociarEquipo(int idEquipo, int idLaboratorioN);

}