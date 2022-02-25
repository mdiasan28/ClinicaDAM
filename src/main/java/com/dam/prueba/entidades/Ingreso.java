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

@Entity
@Table(name = "ingresos")
public class Ingreso {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;

	@NotEmpty(message = "no puede estar vacio")
	@Column(nullable = false)
	private String numerohabitacion;

	@NotEmpty(message = "no puede estar vacio")
	@Column(nullable = false)
	private String cama;
	
	@Temporal(TemporalType.DATE)
	@Column(nullable = false)
	private Date fechaingreso;
	
	
	private static final long serialVersionUID = 1L;
	
}
