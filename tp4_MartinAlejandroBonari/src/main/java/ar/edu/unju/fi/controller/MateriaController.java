package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ar.edu.unju.fi.repository.ICarreraRepository;
import ar.edu.unju.fi.repository.IDocenteRepository;
import ar.edu.unju.fi.repository.IMateriaRepository;
import ar.edu.unju.fi.enumerados.Modalidad;
import ar.edu.unju.fi.model.Carrera;
import ar.edu.unju.fi.model.Docente;
import ar.edu.unju.fi.model.Materia;

@Controller
@RequestMapping("/materia")
public class MateriaController {
	
    @Autowired
    private IMateriaRepository materiaRepository;

    @Autowired
    private IDocenteRepository docenteRepository;

    @Autowired
    private ICarreraRepository carreraRepository;

    @GetMapping("/listado")
    public String getListaMateriasPage(Model model) {
        model.addAttribute("materias", materiaRepository.findAll());
        model.addAttribute("titulo", "Materias");
        return "/eMateria/materias";
    }

    @GetMapping("/nuevo")
    public String getNuevaMateriaPage(Model model) {
        model.addAttribute("materia", new Materia());
        model.addAttribute("edicion", false);
        model.addAttribute("docentes", docenteRepository.findAll());
        model.addAttribute("carreras", carreraRepository.findAll());
        model.addAttribute("modalidad", Modalidad.values());
        model.addAttribute("titulo", "Nueva Materia");
        return "/eMateria/materia";
    }

    @PostMapping("/guardar")
    public String guardarMateria(@ModelAttribute("materia") Materia materia, Model model) {
        Docente docenteSeleccionado = docenteRepository.findById(materia.getDocente().getLegajo()).orElse(null);
        Carrera carreraSeleccionada = carreraRepository.findById(materia.getCarrera().getCodigo()).orElse(null);

        if (docenteSeleccionado != null && carreraSeleccionada != null) {
            materia.setDocente(docenteSeleccionado);
            materia.setCarrera(carreraSeleccionada);
            materiaRepository.save(materia);
            return "redirect:/materia/listado";
        } else {
            if (docenteSeleccionado == null) {
                model.addAttribute("errorDocente", "No se encontró el docente seleccionado.");
            }
            if (carreraSeleccionada == null) {
                model.addAttribute("errorCarrera", "No se encontró la carrera seleccionada.");
            }
            model.addAttribute("docentes", docenteRepository.findAll());
            model.addAttribute("carreras", carreraRepository.findAll());
            return "/eMateria/materia";
        }
    }

    @GetMapping("/modificar/{codigo}")
    public String getModificarMateriaPage(Model model, @PathVariable("codigo") Integer codigo) {
        Materia materia = materiaRepository.findById(codigo).orElse(null);
        model.addAttribute("materia", materia);
        model.addAttribute("edicion", true);
        model.addAttribute("docentes", docenteRepository.findAll());
        model.addAttribute("carreras", carreraRepository.findAll());
        model.addAttribute("modalidad", Modalidad.values());
        model.addAttribute("titulo", "Modificar Materia");
        return "/eMateria/materia";
    }

    @PostMapping("/modificar")
    public String modificarMateria(@ModelAttribute("materia") Materia materia, Model model) {
        Docente docenteSeleccionado = docenteRepository.findById(materia.getDocente().getLegajo()).orElse(null);
        Carrera carreraSeleccionada = carreraRepository.findById(materia.getCarrera().getCodigo()).orElse(null);

        if (docenteSeleccionado != null && carreraSeleccionada != null) {
            materia.setDocente(docenteSeleccionado);
            materia.setCarrera(carreraSeleccionada);
            materiaRepository.save(materia);
            return "redirect:/materia/listado";
        } else {
            if (docenteSeleccionado == null) {
                model.addAttribute("errorDocente", "No se encontró el docente seleccionado.");
            }
            if (carreraSeleccionada == null) {
                model.addAttribute("errorCarrera", "No se encontró la carrera seleccionada.");
            }
            model.addAttribute("docentes", docenteRepository.findAll());
            model.addAttribute("carreras", carreraRepository.findAll());
            return "/eMateria/materia";
        }
    }

    @GetMapping("/eliminar/{codigo}")
    public String eliminarMateria(@PathVariable("codigo") Integer codigo) {
        materiaRepository.deleteById(codigo);
        return "redirect:/materia/listado";
    }
}