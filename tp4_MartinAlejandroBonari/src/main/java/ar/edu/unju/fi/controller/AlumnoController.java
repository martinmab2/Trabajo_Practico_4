package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import ar.edu.unju.fi.dto.AlumnoDTO;
import ar.edu.unju.fi.services.IAlumnoService;
import jakarta.validation.Valid;


@Controller
@RequestMapping("/alumno")
public class AlumnoController {

    @Autowired
    private IAlumnoService alumnoService;

    @GetMapping("/listado")
    public String getListaAlumnosPage(Model model) {
        model.addAttribute("alumnos", alumnoService.getAllALumnos());
        model.addAttribute("titulo", "Alumnos");
        return "eAlumno/alumnos";
    }

    @GetMapping("/nuevo")
    public String getNuevoAlumnoPage(Model model) {
        model.addAttribute("alumno", new AlumnoDTO());
        model.addAttribute("edicion", false);
        model.addAttribute("titulo", "Nuevo Alumno");
        return "eAlumno/alumno";
    }

    @PostMapping("/guardar")
    public ModelAndView crearAlumno(@Valid @ModelAttribute("alumno") AlumnoDTO alumnoDTO, BindingResult result) {
        ModelAndView modelView;
        if (result.hasErrors()) {
            modelView = new ModelAndView("eAlumno/alumno");
            modelView.addObject("alumno", alumnoDTO);
            modelView.addObject("edicion", false);
            modelView.addObject("titulo", "Nuevo Alumno");
        } else {
            modelView = new ModelAndView("redirect:/alumno/listado");
            alumnoService.crearAlumno(alumnoDTO);
        }
        return modelView;
    }

    @GetMapping("/modificar/{id}")
    public String getModificarAlumnoPage(Model model, @PathVariable("id") Long id) {
        AlumnoDTO alumno = alumnoService.buscarAlumno(id);
        if (alumno != null) {
            model.addAttribute("edicion", true);
            model.addAttribute("alumno", alumno);
            model.addAttribute("titulo", "Modificar Alumno");
            return "eAlumno/alumno";
        } else {
            return "redirect:/alumno/listado";
        }
    }

    @PostMapping("/modificar")
    public String modificarAlumno(@Valid @ModelAttribute("alumno") AlumnoDTO alumnoDTO, BindingResult result) {
        if (result.hasErrors()) {
            return "eAlumno/alumno";
        } else {
            alumnoService.modificarAlumno(alumnoDTO);
            return "redirect:/alumno/listado";
        }
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarAlumno(@PathVariable("id") Long id) {
        alumnoService.eliminarAlumno(id);
        return "redirect:/alumno/listado";
    }
}
