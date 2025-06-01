package com.example.GestionAcademica.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.GestionAcademica.modelos.Alumno;
import com.example.GestionAcademica.service.Alumno.AlumnoInterface;
import com.example.GestionAcademica.service.grupo.GrupoInterface;

import jakarta.validation.Valid;

@Controller
@SessionAttributes("alumno")
public class AlumnoController {

    private final AlumnoInterface alumnoServicio;
    private final GrupoInterface grupoServicio;
    public AlumnoController(AlumnoInterface alumnoInterface, GrupoInterface grupoInterface) {
        this.grupoServicio = grupoInterface;
        this.alumnoServicio = alumnoInterface;
    }

    //Nuevo alumno
    @GetMapping("/alumno/nuevo")
    public String nuevoAlumno(Model model) {
        Alumno alumno = new Alumno();
        model.addAttribute("alumno", alumno);
        model.addAttribute("grupos", grupoServicio.obtenerTodosLosGrupos());
        return "alumno/nuevo-alumno";
    }
  @PostMapping("/alumno/guardar")
    public String guardarAlumno(@Valid @ModelAttribute Alumno alumno, BindingResult errors,
                               Model model, SessionStatus status, RedirectAttributes flash) {

        if (errors.hasErrors()) {
            model.addAttribute("grupos", grupoServicio.obtenerTodosLosGrupos());
            flash.addFlashAttribute("mensajeError", "Por favor, corrige los errores en el formulario.");
            return "alumno/nuevo-alumno"; 
        }

        alumnoServicio.guardarAlumno(alumno);
        status.setComplete();
        flash.addFlashAttribute("success", "El alumno ha sido guardado exitosamente.");
        return "redirect:/alumno/lista";
    }


    //Lista de alumnos
    @GetMapping("/alumno/lista")
    public String listaAlumnos(Model model) {
        List<Alumno> alumnos = alumnoServicio.obtenerTodosLosAlumnos();
        model.addAttribute("alumnos", alumnos);
        return "alumno/lista-alumnos";
    }
    //Editar alumno
    @GetMapping("/alumno/editar/{id}")
    public String editarAlumno(@PathVariable int id, Model model) {
        Alumno alumno = alumnoServicio.obtenerAlumnoPorId(id);
        if (alumno != null) {
            model.addAttribute("alumno", alumno);
            model.addAttribute("grupos", grupoServicio.obtenerTodosLosGrupos());
            return "alumno/nuevo-alumno";
        } else {
            return "redirect:/alumno/lista"; 
        }
    }
    
    //Eliminar alumno
    @GetMapping("/alumno/eliminar/{id}")
    public String eliminarAlumno(@PathVariable int id, Model model, RedirectAttributes flash) {
        Alumno alumno = alumnoServicio.obtenerAlumnoPorId(id);
        if (alumno != null) {
            alumnoServicio.eliminarAlumno(id);
            flash.addFlashAttribute("success", "El alumno ha sido eliminado exitosamente.");
        } else {
            flash.addFlashAttribute("error", "El alumno no fue encontrado.");
        }
        return "redirect:/alumno/lista";
    }

    //Buscar alumno
    @GetMapping("/alumno/consultar/{id}")   
    public String consultarAlumno(@PathVariable int id, Model model) {
        Alumno alumno = alumnoServicio.obtenerAlumnoPorId(id);
        if (alumno != null) {
            model.addAttribute("alumno", alumno);
        } else {
            return "redirect:/alumno/lista"; 
        }
        return "alumno/consultar-alumno";
    }
    
}
