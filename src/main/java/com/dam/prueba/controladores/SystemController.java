package com.dam.prueba.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("*")
public class SystemController {
	
	
	//Capta cualquier solicitud
	@GetMapping
	public String showIndex() {
		return "index";
	}
	
	//Redirecciona al controlador de gestión de coches
	@GetMapping("/pacientesView")
	public String redirectToCarDealershipController() {
		return "redirect:showPacientesView";
	}
	
	
	//Redirecciona a la plantilla de insercción
	@GetMapping("/newPacienteView")
	public String redirectToNewCarTemplate() {
		return "newPaciente";
	}

}
