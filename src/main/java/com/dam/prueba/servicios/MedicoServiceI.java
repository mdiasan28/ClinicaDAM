package com.dam.prueba.servicios;

import java.util.List;
import java.util.Optional;

import com.dam.prueba.entidades.Medico;

/**
 * 
 * Servicios de medicos
 *
 */

public interface MedicoServiceI {

	public List<Medico> obtenerTodosMedicos();

	public void aniadirMedico(final Medico medico);

	public void actualizarMedico(final Medico medico);
	
	public void eliminarMedicoPorId(long IdMedico);
	
	public Medico findMedicoByID(long idMedico);

	
}
