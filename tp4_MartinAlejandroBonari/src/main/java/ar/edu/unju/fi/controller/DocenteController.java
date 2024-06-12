package ar.edu.unju.fi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ar.edu.unju.fi.collections.DocenteCollection;

@Controller
@RequestMapping("/docente")
public class DocenteController {
	@GetMapping("/listado")
	public String getDocentePage (Model model){
		model.addAttribute("titulo", "Docentes");
		model.addAttribute("docentes", DocenteCollection.getDocentes());
		return "docentes";
	}
}
