package com.dam.prueba.servicios;

import java.util.List;

import com.dam.prueba.entidades.Paciente;


public interface PacienteServiceI {

	public List<Paciente> obtenerTodosPacientes();

	public void aniadirPaciente(final Paciente paciente);

	public void actualizarPaciente(final Paciente paciente);

	public void eliminarPacientePorId(long IdPaciente);
}
