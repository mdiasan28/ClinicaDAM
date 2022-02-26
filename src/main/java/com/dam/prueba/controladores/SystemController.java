package com.dam.prueba.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("*")
public class SystemController {

	// Capta cualquier solicitud
	@GetMapping
	public String showIndex() {
		return "index";
	}

	// Redirecciona al controlador de gestión de pacientes
	@GetMapping("/pacientesView")
	public String redirectToPacienteController() {
		return "redirect:showPacientesView";
	}

	// Redirecciona al controlador de gestión de medicos
	@GetMapping("/medicosView")
	public String redirectToMedicoController() {
		return "redirect:showMedicosView";
	}

	// Redirecciona al controlador de gestión de medicos
	@GetMapping("/ingresosView")
	public String redirectToIngresoController() {
		return "redirect:showIngresosView";
	}

	// Redirecciona al controlador de gestión de medicos
	@GetMapping("/ingresosmedicoView")
	public String redirectToIngreso3Controller() {
		return "redirect:showIngresosMedicoPrev";
	}
	
	// Redirecciona al controlador de gestión de medicos
		@GetMapping("/ingresospacienteView")
		public String redirectToIngreso4Controller() {
			return "redirect:showIngresosPacientePrev";
		}

	// Redirecciona al controlador de gestión de medicos
	@GetMapping("/newIngresoView")
	public String redirectToIngresoPrevController() {
		return "redirect:actAddIngresoPrev";
	}

	// Redirecciona a la plantilla de insercción
	@GetMapping("/newPacienteView")
	public String redirectToNewPacienteTemplate() {
		return "newPaciente";
	}

	// Redirecciona a la plantilla de insercción
	@GetMapping("/newMedicoView")
	public String redirectToNewMedicoTemplate() {
		return "newMedico";
	}

}
