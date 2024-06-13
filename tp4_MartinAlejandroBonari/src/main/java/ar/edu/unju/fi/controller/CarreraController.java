package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.collections.CarreraCollection;
import ar.edu.unju.fi.model.Carrera;

@Controller
@RequestMapping("/carrera")
public class CarreraController {
	
	@Autowired
	private Carrera carrera;
	
	@GetMapping("/listado")
	public String getCarrerasPage(Model model) {
		model.addAttribute("carreras", CarreraCollection.getCarreras());
		model.addAttribute("titulo", "Carreras");
		return "carreras";
	}
	
	@GetMapping("/nuevo")
	public String getAddCarreraPage(Model model) {
		boolean edicion=false;
		model.addAttribute("carrera", carrera);
		model.addAttribute("edicion", edicion);
		model.addAttribute("titulo", "Agregar Carrera");
		return "carrera";
	}
	
	@PostMapping("/guardar")
	public String guardarCarrera(@ModelAttribute("carrera") Carrera carrera) {
		ModelAndView modelView = new ModelAndView("carreras");
		CarreraCollection.agregarCarrera(carrera);
		modelView.addObject("carreras", CarreraCollection.getCarreras());
		return "redirect:/carrera/listado";
	}
	
	@GetMapping("/modificar/{codigo}")
	public String getModificarCarreraPage(Model model, @PathVariable(value="codigo") String codigo) {
		Carrera carreraEncontrada = new Carrera();
		boolean edicion=true;
		carreraEncontrada = CarreraCollection.buscarCarreraConCodigo(codigo);
		model.addAttribute("edicion", edicion);
		model.addAttribute("carrera", carreraEncontrada);
		model.addAttribute("titulo", "Editar Carrera");
		return "carrera";
	}
	
	@PostMapping("/modificar")
	public String modificarCarrera(@ModelAttribute("carrera") Carrera carrera) {
		CarreraCollection.modificarCarrera(carrera);
		return "redirect:/carrera/listado";
	}
	
	@GetMapping("/eliminar/{codigo}")
	public String eliminarCarrera(@PathVariable(value="codigo") String codigo) {
		CarreraCollection.eliminarCarrera(codigo);
		return "redirect:/carrera/listado";
	}
}
