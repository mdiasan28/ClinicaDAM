package com.dam.prueba.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.dam.prueba.entidades.Ingreso;

@Repository
public interface IngresoRepositorio extends JpaRepository<Ingreso, Long> {
	
	 @Query(value = "SELECT * FROM ingresos WHERE paciente_id = ?", nativeQuery = true)
	 List <Ingreso> findIngresoByCliente(String idCliente);
	 
	 @Query(value = "SELECT * FROM ingresos WHERE medico_id = ?", nativeQuery = true)
	 List <Ingreso> findIngresoByMedico(String idMedico);

}
