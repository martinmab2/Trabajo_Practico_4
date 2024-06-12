package ar.edu.unju.fi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ar.edu.unju.fi.collections.AlumnoCollection;

@Controller
@RequestMapping("/alumno")

public class AlumnoController {
	@GetMapping("/listado")
	public String getAlumnosPage(Model model) {
		model.addAttribute("alumnos", AlumnoCollection.getAlumnos());
		model.addAttribute("titulo", "Alumnos");
		return "alumnos";
	}
}
