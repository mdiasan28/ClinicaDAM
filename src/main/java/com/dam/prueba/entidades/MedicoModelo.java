package com.dam.prueba.entidades;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * Clase Medico Modelo que no realiza validaciones
 *
 */

@Data @AllArgsConstructor @NoArgsConstructor
public class MedicoModelo {


	private String codigo;
	
	private String nombre;


	private String apellido;
	

	private String telefono;
	

	private String especialidad;

	
	private static final long serialVersionUID = 1L;				

}
