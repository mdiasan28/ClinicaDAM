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

/**
 * 
 * Controlador de los ingresos
 *
 */

@Controller
public class IngresoController {

	@Autowired
	private IngresoServiceI ingresoServiceI;
	@Autowired
	private PacienteServiceI pacienteServiceI;
	@Autowired
	private MedicoServiceI medicoServiceI;

	/**
	 * Mostrar ingresos vista principal
	 * @param model
	 * @return Lista de ingresos en su vista principal
	 */
	@GetMapping("/showIngresosView")
	public String mostraringresos(Model model) {

		// Obtención de pacientes
		final List<Ingreso> listaIngresos = ingresoServiceI.obtenerTodosIngresos();

		// Carga de datos al modelo
		model.addAttribute("IngresosListView", listaIngresos);
		model.addAttribute("btnDropMedicoEnabled", Boolean.FALSE);

		return "showIngresos";
	}

	/**
	 * Lista de ingresos por medico
	 * @param medicomodelo es el medico que se recoge de modelo para obtener su codigo
	 * @param model
	 * @return devuelve la lista de ingresos que coinciden con el codigo del medico
	 */
	@PostMapping("/showIngresosMedicoView")
	public String mostraringresosmedicos(@Valid @ModelAttribute MedicoModelo medicomodelo, Model model) {

		// Obtención de pacientes
		final List<Ingreso> listaIngresos = ingresoServiceI.findIngresosByMedico(Long.valueOf(medicomodelo.getCodigo()));

		// Carga de datos al modelo
		model.addAttribute("IngresosListView", listaIngresos);
		model.addAttribute("btnDropMedicoEnabled", Boolean.FALSE);

		return "showIngresos";
	}
	
	/**
	 * Vista con los medicos a seleccionar
	 * @param model
	 * @return Vista que tiene cargado en un combobox todos los medicos
	 */
	
	@GetMapping("/showIngresosMedicoPrev")
	public String mostraringresosmedicosprev(Model model) {

		// Obtención de pacientes
		final List<Medico> listaMedicos = medicoServiceI.obtenerTodosMedicos();

		// Carga de datos al modelo
		model.addAttribute("MedicosListView", listaMedicos);
		model.addAttribute("btnDropMedicoEnabled", Boolean.FALSE);

		return "showIngresosMedicos";
	}

	/**
	 * Vista de los ingresos que coinciden con un paciente
	 * @param pacientemodelo paciente al que se le obtendrá el codigo
	 * @param model
	 * @return ingresos por paciente
	 */
	@PostMapping("/showIngresosPacienteView")
	public String mostraringresospacientes(@Valid @ModelAttribute PacienteModelo pacientemodelo, Model model) {

		// Obtención de pacientes
		final List<Ingreso> listaIngresos = ingresoServiceI.findIngresosByPaciente(Long.valueOf(pacientemodelo.getCodigo()));

		// Carga de datos al modelo
		model.addAttribute("IngresosListView", listaIngresos);
		model.addAttribute("btnDropMedicoEnabled", Boolean.FALSE);

		return "showIngresos";
	}
	
	/**
	 * Lista de pacientes cargados en un combobox
	 * @param model
	 * @return pacientes cargados
	 */
	
	@GetMapping("/showIngresosPacientePrev")
	public String mostraringresospacientesprev(Model model) {

		// Obtención de pacientes
		final List<Paciente> listaPacientes = pacienteServiceI.obtenerTodosPacientes();

		// Carga de datos al modelo
		model.addAttribute("PacientesListView", listaPacientes);
		model.addAttribute("btnDropMedicoEnabled", Boolean.FALSE);

		return "showIngresosPacientes";
	}
	
	/**
	 * Vista de aniadir ingresos que contiene los medicos y pacientes cargados
	 * @param model
	 * @return vista de aniadir ingresos
	 */

	@GetMapping("/actAddIngresoPrev")
	private String aniadirIngresoPrev(Model model) {

		List<Paciente> p = pacienteServiceI.obtenerTodosPacientes();
		List<Medico> m = medicoServiceI.obtenerTodosMedicos();

		// Carga de datos al modelo
		model.addAttribute("PacientesListView", p);
		model.addAttribute("MedicosListView", m);

		return "newIngreso";

	}

	/**
	 * Método que crea un nuevo ingreso
	 * @param ingresomodelo
	 * @param result
	 * @return vista de ingresos
	 * @throws Exception
	 */
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
	
	/**
	 * Metodo que elimina un ingresos
	 * @param ingresoId para eliminar
	 * @param model
	 * @return vista principal de ingresos
	 */
	@PostMapping("/actDropIngreso")
	public String eliminarIngreso(@RequestParam String ingresoId, Model model) {

		// Eliminación de vehículo
		ingresoServiceI.eliminarIngresoPorId(Long.valueOf(ingresoId));

		return "redirect:showIngresosView";

	}

}
