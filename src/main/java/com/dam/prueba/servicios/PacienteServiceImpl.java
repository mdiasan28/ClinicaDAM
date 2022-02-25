package com.dam.prueba.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dam.prueba.entidades.Paciente;
import com.dam.prueba.repositorios.PacienteRepositorio;

@Service
public class PacienteServiceImpl implements PacienteServiceI{

	@Autowired
	private PacienteRepositorio pacienteRepositorio;

	@Override
	public List<Paciente> obtenerTodosPacientes() {
		return pacienteRepositorio.findAll();
	}

	@Override
	public void aniadirPaciente(Paciente paciente) {
		pacienteRepositorio.save(paciente);	
	}

	@Override
	public void actualizarPaciente(Paciente paciente) {
		pacienteRepositorio.save(paciente);		
	}
	
	@Override
	public void eliminarPacientePorId(long IdPaciente) {
		pacienteRepositorio.deleteById(IdPaciente);	
	}
	

}
