package com.dam.prueba.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dam.prueba.entidades.Medico;

@Repository
public interface MedicoRepositorio extends JpaRepository<Medico, Long> {
	

}
