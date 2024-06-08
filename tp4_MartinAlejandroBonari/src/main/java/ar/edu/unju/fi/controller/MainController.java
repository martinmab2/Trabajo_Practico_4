package ar.edu.unju.fi.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import ar.edu.unju.fi.collections.CarreraCollection;
@Controller
public class MainController {
	@GetMapping("/inicio")
   public String getIndexPage(Model model) {
		model.addAttribute("titulo", "Inicio");
		return "index";
	}
	@GetMapping("/carrera")
	public String getCarrerasPage(Model model) {
		model.addAttribute("carreras", CarreraCollection.getCarreras());
		return "carreras";
		}
}