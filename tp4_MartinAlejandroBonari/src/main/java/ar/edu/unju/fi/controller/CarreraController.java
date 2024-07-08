package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ar.edu.unju.fi.model.Carrera;
import ar.edu.unju.fi.repository.ICarreraRepository;

@Controller
@RequestMapping("/carrera")
public class CarreraController {

	@Autowired
	private ICarreraRepository carreraRepository;

	@GetMapping("/listado")
	public String getListaCarrerasPage(Model model) {
		model.addAttribute("carreras", carreraRepository.findAll());
		model.addAttribute("titulo", "Carreras");
		return "carreras";
	}

	@GetMapping("/nuevo")
	public String getNuevaCarreraPage(Model model) {
		model.addAttribute("carrera", new Carrera());
		model.addAttribute("edicion", false);
		model.addAttribute("titulo", "Nueva Carrera");
		return "carrera";
	}

	@PostMapping("/guardar")
	public String guardarCarrera(@ModelAttribute("carrera") Carrera carrera) {
		carreraRepository.save(carrera);
		return "redirect:/carrera/listado";
	}

	@GetMapping("/modificar/{codigo}")
	public String getModificarCarreraPage(Model model, @PathVariable("codigo") Long codigo) {
		Carrera carrera = carreraRepository.findById(codigo).orElse(null);
		model.addAttribute("carrera", carrera);
		model.addAttribute("edicion", true);
		model.addAttribute("titulo", "Modificar Carrera");
		return "carrera";
	}

	@PostMapping("/modificar")
	public String modificarCarrera(@ModelAttribute("carrera") Carrera carrera) {
		carreraRepository.save(carrera);
		return "redirect:/carrera/listado";
	}

	@GetMapping("/eliminar/{codigo}")
	public String eliminarCarrera(@PathVariable("codigo") Long codigo) {
		carreraRepository.deleteById(codigo);
		return "redirect:/carrera/listado";
	}
}