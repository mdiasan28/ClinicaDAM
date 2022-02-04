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

@Entity
@Table(name = "pacientes")
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
	
	@NotEmpty(message = "no puede estar vacio")
	@Size(min = 5, message = "el tamaño minimo tiene que ser de 5")
	@Column(nullable = false)
	private Long codigopostal;
	
	@NotEmpty(message = "no puede estar vacio")
	@Size(min = 9, message = "el tamaño minimo tiene que ser de 9")
	@Column(nullable = false, unique = true)
	private Long telefono;
	
	@NotEmpty(message = "no puede estar vacio")
	@Temporal(TemporalType.DATE)
	@Column(nullable = false, unique = true)
	private Date fechanacimiento;


	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "paciente_id")
	private List<Ingreso> ingresos;	
	
	private static final long serialVersionUID = 1L;

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getPoblacion() {
		return poblacion;
	}

	public void setPoblacion(String poblacion) {
		this.poblacion = poblacion;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public Long getCodigopostal() {
		return codigopostal;
	}

	public void setCodigopostal(Long codigopostal) {
		this.codigopostal = codigopostal;
	}

	public Long getTelefono() {
		return telefono;
	}

	public void setTelefono(Long telefono) {
		this.telefono = telefono;
	}

	public Date getFechanacimiento() {
		return fechanacimiento;
	}

	public void setFechanacimiento(Date fechanacimiento) {
		this.fechanacimiento = fechanacimiento;
	}

	public List<Ingreso> getIngresos() {
		return ingresos;
	}

	public void setIngresos(List<Ingreso> ingresos) {
		this.ingresos = ingresos;
	}
	
	
	

}
