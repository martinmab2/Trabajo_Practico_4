package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ar.edu.unju.fi.model.Alumno;
import ar.edu.unju.fi.repository.IAlumnoRepository;

@Controller
@RequestMapping("/alumno")
public class AlumnoController {

    @Autowired
    private IAlumnoRepository alumnoRepository;

    @GetMapping("/listado")
    public String getListaAlumnosPage(Model model) {
        model.addAttribute("alumnos", alumnoRepository.findAll());
        model.addAttribute("titulo", "Alumnos");
        return "alumnos";
    }

    @GetMapping("/nuevo")
    public String getNuevoAlumnoPage(Model model) {
        model.addAttribute("alumno", new Alumno());
        model.addAttribute("edicion", false);
        model.addAttribute("titulo", "Nuevo Alumno");
        return "alumno";
    }

    @PostMapping("/guardar")
    public String guardarAlumno(@ModelAttribute("alumno") Alumno alumno) {
        alumnoRepository.save(alumno);
        return "redirect:/alumno/listado";
    }

    @GetMapping("/modificar/{dni}")
    public String getModificarAlumnoPage(Model model, @PathVariable("dni") Integer dni) {
        Alumno alumno = alumnoRepository.findById(dni).orElse(null);
        model.addAttribute("alumno", alumno);
        model.addAttribute("edicion", true);
        model.addAttribute("titulo", "Modificar Alumno");
        return "alumno";
    }

    @PostMapping("/modificar")
    public String modificarAlumno(@ModelAttribute("alumno") Alumno alumno) {
        alumnoRepository.save(alumno);
        return "redirect:/alumno/listado";
    }

    @GetMapping("/eliminar/{dni}")
    public String eliminarAlumno(@PathVariable("dni") Integer dni) {
        alumnoRepository.deleteById(dni);
        return "redirect:/alumno/listado";
    }
}