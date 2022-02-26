package com.dam.prueba.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dam.prueba.entidades.Ingreso;
import com.dam.prueba.repositorios.IngresoRepositorio;

@Service
public class IngresoServiceImpl implements IngresoServiceI{

	@Autowired
	private IngresoRepositorio ingresoRepositorio;

	@Override
	public void aniadirIngreso(Ingreso ingreso) {
		ingresoRepositorio.save(ingreso);
		
	}

	@Override
	public List<Ingreso> obtenerTodosIngresos() {	
		return ingresoRepositorio.findAll();
	}

	@Override
	public List<Ingreso> findIngresosByMedico(long idMedico) {
		return ingresoRepositorio.findIngresosByMedico(idMedico);
		
	}

	@Override
	public List<Ingreso> findIngresosByPaciente(long idPaciente) {
		return ingresoRepositorio.findIngresosByPaciente(idPaciente);
		
	}


	

}
