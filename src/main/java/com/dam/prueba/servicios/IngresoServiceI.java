package com.dam.prueba.servicios;


import java.util.List;

import com.dam.prueba.entidades.Ingreso;
/**
 * 
 * Servicios de ingresos
 *
 */

public interface IngresoServiceI {
	
	public List<Ingreso> obtenerTodosIngresos();

	public void aniadirIngreso(final Ingreso ingreso);


	List<Ingreso> findIngresosByMedico(long idMedico);


	List<Ingreso> findIngresosByPaciente(long idCliente);
	
	public void eliminarIngresoPorId(long IdMedico);

}
