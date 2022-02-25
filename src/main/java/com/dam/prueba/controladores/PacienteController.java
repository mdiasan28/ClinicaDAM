package com.dam.prueba.controladores;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dam.prueba.entidades.Medico;
import com.dam.prueba.entidades.Paciente;
import com.dam.prueba.entidades.PacienteModelo;
import com.dam.prueba.servicios.PacienteServiceI;

@Controller
public class PacienteController {

	@Autowired
	private PacienteServiceI pacienteServiceI;

	@RequestMapping("/home")
	@ResponseBody
	public String home() {
		return "hello world";
	}

	@GetMapping("/showPacientesView")
	public String mostrarPacientes(Model model) {

		// Obtención de pacientes
		final List<Paciente> listaPacientes = pacienteServiceI.obtenerTodosPacientes();

		// Carga de datos al modelo
		model.addAttribute("PacientesListView", listaPacientes);
		model.addAttribute("btnDropPacienteEnabled", Boolean.FALSE);

		return "showPacientes";
	}

	@GetMapping("/editPacientesView")
	public String editarPacientes(String pacienteId, Model model) {

		// Obtención de pacientes
		Paciente p = pacienteServiceI.finfPacienteById(Long.valueOf(pacienteId));

		// Carga de datos al modelo
		model.addAttribute("nombre", p.getNombre());
		model.addAttribute("apellido", p.getApellido());
		model.addAttribute("cp", p.getCodigopostal());
		model.addAttribute("direccion", p.getDireccion());
		model.addAttribute("fechanacimiento", p.getFechanacimiento());
		model.addAttribute("poblacion", p.getPoblacion());
		model.addAttribute("provincia", p.getProvincia());
		model.addAttribute("telefono", p.getTelefono());
		model.addAttribute("PacienteID", p.getCodigo());

		return "editPaciente";
	}

	@GetMapping("/actEditPaciente")
	public String editarMedico(@Valid @ModelAttribute PacienteModelo Pacientemodelo, BindingResult result) throws Exception {

		Paciente p = new Paciente();

		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date date = formatter.parse(Pacientemodelo.getFechanacimiento());

		p.setCodigo(Pacientemodelo.getCodigo());
		p.setNombre(Pacientemodelo.getNombre());
		p.setApellido(Pacientemodelo.getApellido());
		p.setDireccion(Pacientemodelo.getDireccion());
		p.setPoblacion(Pacientemodelo.getPoblacion());
		p.setProvincia(Pacientemodelo.getProvincia());
		p.setCodigopostal(Pacientemodelo.getCodigopostal());
		p.setTelefono(Pacientemodelo.getTelefono());
		p.setFechanacimiento(date);

		if (result.hasErrors()) {
			throw new Exception("Parámetros de matriculación erróneos");
		}

		// Obtención de pacientes
		pacienteServiceI.actualizarPaciente(p);

		return "redirect:showPacientesView";
	}

	@PostMapping("/actDropPaciente")
	public String eliminarPaciente(@RequestParam String pacienteId, Model model) {

		// Eliminación de vehículo
		pacienteServiceI.eliminarPacientePorId(Long.valueOf(pacienteId));

		return "redirect:showPacientesView";

	}

	@PostMapping("/actAddPaciente")
	private String aniadirPaciente(@Valid @ModelAttribute PacienteModelo Pacientemodelo, BindingResult result)
			throws Exception {

		Paciente p = new Paciente();

		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date date = formatter.parse(Pacientemodelo.getFechanacimiento());

		p.setNombre(Pacientemodelo.getNombre());
		p.setApellido(Pacientemodelo.getApellido());
		p.setDireccion(Pacientemodelo.getDireccion());
		p.setPoblacion(Pacientemodelo.getPoblacion());
		p.setProvincia(Pacientemodelo.getProvincia());
		p.setCodigopostal(Pacientemodelo.getCodigopostal());
		p.setTelefono(Pacientemodelo.getTelefono());
		p.setFechanacimiento(date);

		if (result.hasErrors()) {
			throw new Exception("Parámetros de matriculación erróneos");
		} else {

			// Se añade el nuevo coche
			pacienteServiceI.aniadirPaciente(p);
		}

		return "redirect:showPacientesView";
	}

}
