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
import ar.edu.unju.fi.collections.DocenteCollection;
import ar.edu.unju.fi.model.Docente;

@Controller
@RequestMapping("/docente")
public class DocenteController {
	
	@Autowired
	private Docente docente;
	
	@GetMapping("/listado")
	public String getDocentePage (Model model){
		model.addAttribute("titulo", "Docentes");
		model.addAttribute("docentes", DocenteCollection.getDocentes());
		return "docentes";
	}
	
	@GetMapping("/nuevo")
	public String getAddDocentePage(Model model) {
		boolean edicion=false;
		model.addAttribute("docente", docente);
		model.addAttribute("edicion", edicion);
		model.addAttribute("titulo", "Agregar Docente");
		return "docente";
	}
	
	@PostMapping("/guardar")
	public String guardarDocente(@ModelAttribute("docente") Docente docente) {
		ModelAndView modelView = new ModelAndView("docentes");
		DocenteCollection.agregarDocente(docente);
		modelView.addObject("docentes", DocenteCollection.getDocentes());
		return "redirect:/docente/listado";
	}
	
	@GetMapping("/modificar/{legajo}")
	public String getModificarDocentePage(Model model, @PathVariable(value="legajo") String legajo) {
		Docente docenteEncontrado = new Docente();
		boolean edicion=true;
		docenteEncontrado = DocenteCollection.buscarDocentePorLegajo(legajo);
		model.addAttribute("edicion", edicion);
		model.addAttribute("docente", docenteEncontrado);
		model.addAttribute("titulo", "Editar Docente");
		return "docente";
	}
	
	@PostMapping("/modificar")
	public String modificarDocente(@ModelAttribute("docente") Docente docente) {
		DocenteCollection.modificarDocente(docente);
		return "redirect:/docente/listado";
	}
	
	@GetMapping("/eliminar/{legajo}")
	public String eliminarDocente(@PathVariable(value="legajo") String legajo) {
		DocenteCollection.eliminarDocente(legajo);
		return "redirect:/docente/listado";
	}
}
