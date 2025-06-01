package com.example.GestionAcademica.controllers;

import com.example.GestionAcademica.modelos.Calificacion;
import com.example.GestionAcademica.service.Alumno.AlumnoInterface;
import com.example.GestionAcademica.service.calificacion.CalificacionInterface;
import com.example.GestionAcademica.service.grupo.GrupoInterface;

import jakarta.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.bind.support.SessionStatus;

import java.util.List;

@Controller
@RequestMapping("/calificacion")
@SessionAttributes("calificacion")
public class CalificacionController {

    private final CalificacionInterface calificacionServicio;
    private final AlumnoInterface alumnoServicio;
    private final GrupoInterface grupoServicio;

    public CalificacionController(CalificacionInterface calificacionServicio,
                                  AlumnoInterface alumnoServicio,
                                  GrupoInterface grupoServicio) {
        this.calificacionServicio = calificacionServicio;
        this.alumnoServicio = alumnoServicio;
        this.grupoServicio = grupoServicio;
    }

    // Mostrar formulario nueva calificación
    @GetMapping("/nueva")
    public String nuevaCalificacion(Model model) {
        model.addAttribute("calificacion", new Calificacion());
        model.addAttribute("alumnos", alumnoServicio.obtenerTodosLosAlumnos());
        model.addAttribute("grupos", grupoServicio.obtenerTodosLosGrupos());
        return "calificacion/nueva-calificacion";
    }

    // Guardar calificación
    @PostMapping("/guardar")
    public String guardarCalificacion(@Valid @ModelAttribute Calificacion calificacion,
                                      BindingResult errors,
                                      Model model,
                                      RedirectAttributes flash,
                                      SessionStatus status) {
        if (errors.hasErrors()) {
            model.addAttribute("alumnos", alumnoServicio.obtenerTodosLosAlumnos());
            model.addAttribute("grupos", grupoServicio.obtenerTodosLosGrupos());
            model.addAttribute("errors", "Corrige los errores del formulario.");
            return "calificacion/nueva-calificacion";
        }

        calificacionServicio.guardarCalificacion(calificacion);
        status.setComplete();
        flash.addFlashAttribute("success", "Calificación guardada correctamente.");
        return "redirect:/calificacion/lista";
    }

    // Lista de calificaciones
    @GetMapping("/lista")
    public String listaCalificaciones(Model model) {
        List<Calificacion> calificaciones = calificacionServicio.obtenerTodasLasCalificaciones();
        model.addAttribute("calificaciones", calificaciones);
        return "calificacion/lista-calificaciones";
    }

    // Consultar calificación
    @GetMapping("/consultar/{id}")
    public String consultarCalificacion(@PathVariable int id, Model model) {
        Calificacion calificacion = calificacionServicio.obtenerCalificacionPorId(id);
        if (calificacion != null) {
            model.addAttribute("calificacion", calificacion);
        } else {
            return "redirect:/calificacion/lista";
        }
        return "calificacion/consultar-calificacion";
    }

    // Editar calificación
    @GetMapping("/editar/{id}")
    public String editarCalificacion(@PathVariable int id, Model model) {
        Calificacion calificacion = calificacionServicio.obtenerCalificacionPorId(id);
        if (calificacion != null) {
            model.addAttribute("calificacion", calificacion);
            model.addAttribute("alumnos", alumnoServicio.obtenerTodosLosAlumnos());
            model.addAttribute("grupos", grupoServicio.obtenerTodosLosGrupos());
            return "calificacion/editar-calificacion";
        }
        return "redirect:/calificacion/lista";
    }

    // Eliminar calificación
    @GetMapping("/eliminar/{id}")
    public String eliminarCalificacion(@PathVariable int id) {
        calificacionServicio.eliminarCalificacion(id);
        return "redirect:/calificacion/lista";
    }
}
