package com.dam.prueba.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.dam.prueba.entidades.Medico;
import com.dam.prueba.entidades.Paciente;

@Repository
public interface PacienteRepositorio extends JpaRepository<Paciente, Long> {
	
	@Query(value = "SELECT * FROM pacientes WHERE codigo = ?", nativeQuery = true)
	 Paciente findMedicoByID(long idPaciente);
	
}
