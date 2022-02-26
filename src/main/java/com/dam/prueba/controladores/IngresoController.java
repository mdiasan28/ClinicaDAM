package com.dam.prueba.controladores;

import java.text.SimpleDateFormat;
import java.util.Date;
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

import com.dam.prueba.entidades.Ingreso;
import com.dam.prueba.entidades.IngresoModelo;
import com.dam.prueba.entidades.Medico;
import com.dam.prueba.entidades.MedicoModelo;
import com.dam.prueba.entidades.Paciente;
import com.dam.prueba.entidades.PacienteModelo;
import com.dam.prueba.servicios.IngresoServiceI;
import com.dam.prueba.servicios.MedicoServiceI;
import com.dam.prueba.servicios.PacienteServiceI;

@Controller
public class IngresoController {

	@Autowired
	private IngresoServiceI ingresoServiceI;
	@Autowired
	private PacienteServiceI pacienteServiceI;
	@Autowired
	private MedicoServiceI medicoServiceI;

	@GetMapping("/showIngresosView")
	public String mostraringresos(Model model) {

		// Obtención de pacientes
		final List<Ingreso> listaIngresos = ingresoServiceI.obtenerTodosIngresos();

		// Carga de datos al modelo
		model.addAttribute("IngresosListView", listaIngresos);
		model.addAttribute("btnDropMedicoEnabled", Boolean.FALSE);

		return "showIngresos";
	}

	@PostMapping("/showIngresosMedicoView")
	public String mostraringresosmedicos(@Valid @ModelAttribute MedicoModelo medicomodelo, Model model) {

		// Obtención de pacientes
		final List<Ingreso> listaIngresos = ingresoServiceI.findIngresosByMedico(Long.valueOf(medicomodelo.getCodigo()));

		// Carga de datos al modelo
		model.addAttribute("IngresosListView", listaIngresos);
		model.addAttribute("btnDropMedicoEnabled", Boolean.FALSE);

		return "showIngresos";
	}
	
	@GetMapping("/showIngresosMedicoPrev")
	public String mostraringresosmedicosprev(Model model) {

		// Obtención de pacientes
		final List<Medico> listaMedicos = medicoServiceI.obtenerTodosMedicos();

		// Carga de datos al modelo
		model.addAttribute("MedicosListView", listaMedicos);
		model.addAttribute("btnDropMedicoEnabled", Boolean.FALSE);

		return "showIngresosMedicos";
	}

	@PostMapping("/showIngresosPacienteView")
	public String mostraringresospacientes(@Valid @ModelAttribute PacienteModelo pacientemodelo, Model model) {

		// Obtención de pacientes
		final List<Ingreso> listaIngresos = ingresoServiceI.findIngresosByPaciente(Long.valueOf(pacientemodelo.getCodigo()));

		// Carga de datos al modelo
		model.addAttribute("IngresosListView", listaIngresos);
		model.addAttribute("btnDropMedicoEnabled", Boolean.FALSE);

		return "showIngresos";
	}
	
	@GetMapping("/showIngresosPacientePrev")
	public String mostraringresospacientesprev(Model model) {

		// Obtención de pacientes
		final List<Paciente> listaPacientes = pacienteServiceI.obtenerTodosPacientes();

		// Carga de datos al modelo
		model.addAttribute("PacientesListView", listaPacientes);
		model.addAttribute("btnDropMedicoEnabled", Boolean.FALSE);

		return "showIngresosPacientes";
	}

	@GetMapping("/actAddIngresoPrev")
	private String aniadirIngresoPrev(Model model) {

		List<Paciente> p = pacienteServiceI.obtenerTodosPacientes();
		List<Medico> m = medicoServiceI.obtenerTodosMedicos();

		// Carga de datos al modelo
		model.addAttribute("PacientesListView", p);
		model.addAttribute("MedicosListView", m);

		return "newIngreso";

	}

	@PostMapping("/actAddIngreso")
	private String aniadirIngreso(@Valid @ModelAttribute IngresoModelo ingresomodelo, BindingResult result)
			throws Exception {

		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date date = formatter.parse(ingresomodelo.getFechaingreso());

		Paciente p = pacienteServiceI.finfPacienteById(Long.valueOf(ingresomodelo.getPaciente_codigo()));
		Medico m = medicoServiceI.findMedicoByID(Long.valueOf(ingresomodelo.getMedico_codigo()));
		
		//p.setFechanacimiento(date);

		Ingreso i = new Ingreso();
		i.setNumerohabitacion(ingresomodelo.getNumerohabitacion());
		i.setCama(ingresomodelo.getCama());
		i.setFechaingreso(date);
		i.setMedico(m);
		i.setPaciente(p);

		if (result.hasErrors()) {
			throw new Exception("Parámetros de matriculación erróneos");
		} else {

			// Se añade el nuevo coche
			ingresoServiceI.aniadirIngreso(i);
		}

		return "redirect:showIngresosView";
	}

}
