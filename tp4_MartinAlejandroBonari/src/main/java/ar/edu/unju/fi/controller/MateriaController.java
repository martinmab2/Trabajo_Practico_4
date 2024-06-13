package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ar.edu.unju.fi.collections.CarreraCollection;
import ar.edu.unju.fi.collections.DocenteCollection;
import ar.edu.unju.fi.collections.MateriaCollection;
import ar.edu.unju.fi.model.Carrera;
import ar.edu.unju.fi.model.Docente;
import ar.edu.unju.fi.model.Materia;

@Controller
@RequestMapping("/materia")
public class MateriaController {
	
	@Autowired
	private MateriaCollection materiaCollection;
	
	@GetMapping("/listado")
	public String getListaMateriasPage(Model model) {
		model.addAttribute("materias", materiaCollection.getMaterias());
		model.addAttribute("titulo", "Materias");
		return "materias";
	}

	@GetMapping("/nuevo")
	public String getNuevaMateriaPage(Model model) {
		model.addAttribute("materia", new Materia());
		model.addAttribute("edicion", false);
		model.addAttribute("docentes", DocenteCollection.getDocentes());
        model.addAttribute("carreras", CarreraCollection.getCarreras());
        model.addAttribute("titulo", "Nueva Materia");
		return "materia";
	}

	@PostMapping("/guardar")
	public String guardarMateria(@ModelAttribute("materia") Materia materia, Model model) {
	    Docente docenteSeleccionado = DocenteCollection.buscarDocentePorLegajo(materia.getDocente().getLegajo());
	    Carrera carreraSeleccionada = CarreraCollection.buscarCarreraConCodigo(materia.getCarrera().getCodigo()); // Busca por código

	    if (docenteSeleccionado != null && carreraSeleccionada != null) {
	        materia.setDocente(docenteSeleccionado);
	        materia.setCarrera(carreraSeleccionada);
	        materiaCollection.guardarMateria(materia);
	        return "redirect:/materia/listado";
	    } else {
	        if (docenteSeleccionado == null) {
	            model.addAttribute("errorDocente", "No se encontró el docente seleccionado.");
	        }
	        if (carreraSeleccionada == null) {
	            model.addAttribute("errorCarrera", "No se encontró la carrera seleccionada.");
	        }
	        model.addAttribute("docentes", DocenteCollection.getDocentes());
	        model.addAttribute("carreras", CarreraCollection.getCarreras());
	        return "redirect:/materia/listado";
	    }
	}


	@GetMapping("/modificar/{codigo}")
	public String getModificarMateriaPage(Model model, @PathVariable("codigo") int codigo) {
		Materia materia = materiaCollection.buscarMateriaPorCodigo(codigo);
		model.addAttribute("materia", materia);
		model.addAttribute("edicion", true);
		model.addAttribute("docentes", DocenteCollection.getDocentes());
		model.addAttribute("carreras", CarreraCollection.getCarreras());
		model.addAttribute("titulo", "Modificar Materia");
		return "materia";
	}

	@PostMapping("/modificar")
	public String modificarMateria(@ModelAttribute("materia") Materia materia, Model model) {
		materiaCollection.modificarMateria(materia);
		Docente docenteSeleccionado = DocenteCollection.buscarDocentePorLegajo(materia.getDocente().getLegajo());
		Carrera carreraSeleccionada = CarreraCollection.buscarCarreraConCodigo(materia.getCarrera().getCodigo());
		
		if (docenteSeleccionado != null && carreraSeleccionada != null) {
			materia.setDocente(docenteSeleccionado);
			materia.setCarrera(carreraSeleccionada);
			materiaCollection.modificarMateria(materia);
			return "redirect:/materia/listado";
		} else {
			if (docenteSeleccionado == null) {
	            model.addAttribute("errorDocente", "No se encontró el docente seleccionado.");
	        }
	        if (carreraSeleccionada == null) {
	            model.addAttribute("errorCarrera", "No se encontró la carrera seleccionada.");
	        }
	        model.addAttribute("docentes", DocenteCollection.getDocentes());
	        model.addAttribute("carreras", CarreraCollection.getCarreras());
	        return "materia";
		}
	}

	@GetMapping("/eliminar/{codigo}")
	public String eliminarMateria(@PathVariable("codigo") int codigo) {
		materiaCollection.eliminarMateria(codigo);

		return "redirect:/materia/listado";
	}
}
