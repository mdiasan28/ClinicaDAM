package com.dam.prueba.entidades;


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
 * Clase Medico
 *
 */
@Entity
@Table(name = "medicos")
@Data @AllArgsConstructor @NoArgsConstructor
public class Medico {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;

	@NotEmpty(message = "no puede estar vacio")
	@Size(min = 3, max = 12, message = "el tamaño tiene que estar entre 3 y 12")
	@Column(nullable = false)
	private String nombre;

	@NotEmpty(message = "no puede estar vacio")
	@Column(nullable = false)
	private String apellido;
	
	@NotEmpty(message = "no puede estar vacio")
	@Size(min = 9, message = "el tamaño minimo tiene que ser de 9")
	@Column(nullable = false, unique = true)
	private String telefono;
	
	@NotEmpty(message = "no puede estar vacio")
	@Column(nullable = false)
	private String especialidad;


	@JsonIgnoreProperties(value={"medico", "hibernateLazyInitializer", "handler"}, allowSetters=true)
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "medico", cascade = CascadeType.ALL)
	private List<Ingreso> ingresos;	
	
	private static final long serialVersionUID = 1L;				

}
