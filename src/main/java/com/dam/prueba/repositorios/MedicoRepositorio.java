package com.dam.prueba.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.dam.prueba.entidades.Ingreso;
import com.dam.prueba.entidades.Medico;
/**
 * 
 * Repositorio de medicos
 *
 */
@Repository
public interface MedicoRepositorio extends JpaRepository<Medico, Long> {
	/**
	 * Metodo que obtiene un Medico a partir de un codigo
	 * @param idMedico
	 * @return
	 */
	@Query(value = "SELECT * FROM medicos WHERE codigo = ?", nativeQuery = true)
	 Medico findMedicoByID(long idMedico);

}
