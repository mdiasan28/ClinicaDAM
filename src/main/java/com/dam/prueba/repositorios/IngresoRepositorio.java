package com.dam.prueba.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.dam.prueba.entidades.Ingreso;
/**
 * 
 * Repositorio de ingresos
 *
 */
@Repository
public interface IngresoRepositorio extends JpaRepository<Ingreso, Long> {
	
	/**
	 * Recoge la lista de ingresos que pertenecen a un pacienyte
	 * @param idPaciente
	 * @return
	 */
	 @Query(value = "SELECT * FROM ingresos WHERE paciente_codigo = ?", nativeQuery = true)
	 List <Ingreso> findIngresosByPaciente(long idPaciente);
	 
	 /**
	  * Obtiene la lista de ingresos que pertenecen a un medico
	  * @param idMedico
	  * @return
	  */
	 @Query(value = "SELECT * FROM ingresos WHERE medico_codigo = ?", nativeQuery = true)
	 List <Ingreso> findIngresosByMedico(long idMedico);

}
