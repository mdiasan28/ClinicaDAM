package com.dam.prueba.servicios;

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
	public void findIngresoByPaciente(String idPaciente) {
		ingresoRepositorio.findIngresoByPaciente(idPaciente);
		
	}
	
	@Override
	public void findIngresoByMedico(String idMedico) {
		ingresoRepositorio.findIngresoByMedico(idMedico);
		
	}


	

}
