package com.dam.prueba.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dam.prueba.entidades.Medico;
import com.dam.prueba.repositorios.MedicoRepositorio;

/**
 * 
 * Servicios de medicos implementados
 *
 */
@Service
public class MedicoServiceImpl implements MedicoServiceI{

	@Autowired
	private MedicoRepositorio medicoRepositorio;

	@Override
	public List<Medico> obtenerTodosMedicos() {
		return medicoRepositorio.findAll();
	}

	@Override
	public void aniadirMedico(Medico medico) {
		medicoRepositorio.save(medico);
		
	}

	@Override
	public void actualizarMedico(Medico medico) {
		medicoRepositorio.save(medico);
		
	}

	@Override
	public void eliminarMedicoPorId(long IdPaciente) {
		medicoRepositorio.deleteById(IdPaciente);
		
	}


	@Override
	public Medico findMedicoByID(long idMedico) {
		Medico m = medicoRepositorio.findMedicoByID(idMedico);
		return m;
	}


}
