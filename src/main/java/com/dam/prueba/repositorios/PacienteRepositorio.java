package com.dam.prueba.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.dam.prueba.entidades.Medico;
import com.dam.prueba.entidades.Paciente;
/**
 * 
 * Repositorio de pacientes
 *
 */
@Repository
public interface PacienteRepositorio extends JpaRepository<Paciente, Long> {
	
	/**
	 * Metodo que obtiene un paciente a través de su codigo
	 * @param idPaciente
	 * @return
	 */
	@Query(value = "SELECT * FROM pacientes WHERE codigo = ?", nativeQuery = true)
	 Paciente findMedicoByID(long idPaciente);
	
}
