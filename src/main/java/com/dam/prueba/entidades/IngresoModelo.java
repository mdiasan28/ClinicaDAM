package com.dam.prueba.entidades;

import java.util.List;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * Clase ingreso modelo que no realiza validaciones
 *
 */
@Data @AllArgsConstructor @NoArgsConstructor
public class IngresoModelo {

	private Long codigo;


	private String numerohabitacion;

	private String cama;
	
	private String fechaingreso;
	
	private String medico_codigo;
	
	private String paciente_codigo;
	
	
	private static final long serialVersionUID = 1L;
	
}
