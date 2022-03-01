package com.dam.prueba.controladores;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * 
 * Capta cualquier excepcion en los metodos de cualquier controlador.
 *
 */
@ControllerAdvice
public class AdviceController {
	
	/**
	 * Capta cualquier excepcion en los metodos de cualquier controlador.
	 * @param req
	 * @param e
	 * @param model
	 * @return
	 */

	@ExceptionHandler(Exception.class)
	public String handleException(HttpServletRequest req, Exception e, Model model) {

		// Respuesta.
		model.addAttribute("errorMsg", e.getMessage());

		return "error";
	}

}
