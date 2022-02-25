package com.dam.prueba.controladores;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dam.prueba.entidades.Medico;
import com.dam.prueba.entidades.MedicoModelo;
import com.dam.prueba.servicios.MedicoServiceI;

@Controller
public class MedicoController {

	@Autowired
	private MedicoServiceI medicoServiceI;


	@GetMapping("/showMedicosView")
	public String mostrarMedicos(Model model) {

		// Obtención de pacientes
		final List<Medico> listaMedicos = medicoServiceI.obtenerTodosMedicos();

		// Carga de datos al modelo
		model.addAttribute("MedicosListView", listaMedicos);
		model.addAttribute("btnDropMedicoEnabled", Boolean.FALSE);

		return "showMedicos";
	}

	@PostMapping("/actDropMedico")
	public String eliminarMedico(@RequestParam String medicoId, Model model) {

		// Eliminación de vehículo
		medicoServiceI.eliminarMedicoPorId(Long.valueOf(medicoId));

		return "redirect:showMedicosView";

	}

	

	@PostMapping("/actAddMedico")
	private String aniadirMedico(@Valid @ModelAttribute MedicoModelo medicomodelo, BindingResult result) throws Exception {
		
		Medico m = new Medico();
		m.setNombre(medicomodelo.getNombre());
		m.setApellido(medicomodelo.getApellido());
		m.setEspecialidad(medicomodelo.getEspecialidad());
		m.setTelefono(medicomodelo.getTelefono());
		
		
		if (result.hasErrors()) {
			throw new Exception("Parámetros de matriculación erróneos");
		} else {

			// Se añade el nuevo coche
			medicoServiceI.aniadirMedico(m);
		}

		return "redirect:showMedicosView";
	}

}