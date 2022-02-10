package com.dam.prueba.servicios;


import com.dam.prueba.entidades.Ingreso;


public interface IngresoServiceI {

	public void aniadirIngreso(final Ingreso ingreso);


	void findIngresoByMedico(String idMedico);


	void findIngresoByPaciente(String idCliente);

}
