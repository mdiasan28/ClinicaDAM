package com.dam.prueba.servicios;

import java.util.List;

import com.dam.prueba.entidades.Medico;


public interface MedicoServiceI {

	public List<Medico> obtenerTodosMedicos();

	public void aniadirMedico(final Medico medico);

	public void actualizarMedico(final Medico medico);
	
	public void eliminarMedicoPorId(long IdPaciente);
	
}
