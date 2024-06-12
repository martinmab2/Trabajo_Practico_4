package ar.edu.unju.fi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ar.edu.unju.fi.collections.MateriaCollection;
@Controller
@RequestMapping("/materia")
public class MateriaController {
	
	@GetMapping("/listado")
	public String getMateriasPage(Model model) {
		model.addAttribute("materias", MateriaCollection.listaMaterias());
		model.addAttribute("titulo", "Materias");
		return "materias";
	}
}
