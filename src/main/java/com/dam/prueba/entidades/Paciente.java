package com.dam.prueba.entidades;

import java.util.Date;
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

@Entity
@Table(name = "pacientes")
@Data @AllArgsConstructor @NoArgsConstructor
public class Paciente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;

	@NotEmpty(message = "no puede estar vacio")
	@Size(min = 4, message = "el tamaño minimo tiene que ser de 4")
	@Column(nullable = false)
	private String nombre;

	@NotEmpty(message = "no puede estar vacio")
	@Column(nullable = false)
	private String apellido;

	@NotEmpty(message = "no puede estar vacio")
	@Column(nullable = false)
	private String direccion;
	
	@NotEmpty(message = "no puede estar vacio")
	@Column(nullable = false)
	private String poblacion;
	
	@NotEmpty(message = "no puede estar vacio")
	@Column(nullable = false)
	private String provincia;
	
	@Size(min = 5, message = "el tamaño minimo tiene que ser de 5")
	@Column(nullable = false)
	private String codigopostal;
	
	@Size(min = 9, message = "el tamaño minimo tiene que ser de 9")
	@Column(nullable = false, unique = true)
	private String telefono;
	
	@Temporal(TemporalType.DATE)
	@Column(nullable = false, unique = true)
	private Date fechanacimiento;

	@JsonIgnoreProperties(value={"paciente", "hibernateLazyInitializer", "handler"}, allowSetters=true)
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "paciente", cascade = CascadeType.ALL)
	private List<Ingreso> ingresos;	
	
	private static final long serialVersionUID = 1L;


	
	
	

}
