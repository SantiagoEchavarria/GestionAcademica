package com.example.GestionAcademica.controllers;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import com.example.GestionAcademica.modelos.Docente;
import com.example.GestionAcademica.modelos.DocenteMateria;
import com.example.GestionAcademica.modelos.Materia;
import com.example.GestionAcademica.service.Docente.DocenteInterface;
import com.example.GestionAcademica.service.Materia.MateriaInterface;

import jakarta.validation.Valid;


@Controller
@SessionAttributes("docente")
@RequestMapping("/docente")
public class DocenteController {
    private final DocenteInterface docenteServicio;
    private final MateriaInterface materiaSerivicio;
    public DocenteController(DocenteInterface docenteServicio, MateriaInterface materiaSerivicio) {
        this.docenteServicio = docenteServicio;
        this.materiaSerivicio = materiaSerivicio;
    }

    @GetMapping("/nuevo")	
    public String nuevoDocente(Model model) {
       Docente docente = new Docente();
       
       model.addAttribute("docente", docente);
       model.addAttribute("materias", materiaSerivicio.listarMaterias());
       return "docente/nuevo-docente"; 
    }

   @PostMapping("/guardar")
public String guardarDocente(
        @Valid @ModelAttribute Docente docente,
        @RequestParam(value = "materiasIds", required = false) List<Integer> materiasIds,
        BindingResult errors,
        Model model,
        SessionStatus status,
        RedirectAttributes flash) {

    if (errors.hasErrors()) {
        model.addAttribute("error", "Corrige el formulario");
        model.addAttribute("docente", docente);
        model.addAttribute("materias", materiaSerivicio.listarMaterias());
        return "docente/nuevo-docente";
    }
    System.out.println("Maaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaterias seleccionadas: " + materiasIds);

    List<DocenteMateria> relaciones = new ArrayList<>();

    if (materiasIds != null) {
        for (int materiaId : materiasIds) {
            System.out.println("Maaaaaaaaaaaaaaaaaateria id: "+materiaId);
            Materia materia = materiaSerivicio.obtenerMateriaPorId(materiaId);

            System.out.println("Maaaaaaaaaaaaaaaaaateria: "+ materia);
            DocenteMateria relacion = new DocenteMateria();
            relacion.setDocente(docente);
            relacion.setMateria(materia);
            relacion.setFechaInicio(LocalDate.now());

            relaciones.add(relacion);
        }
    }

    docente.setDocenteMateria(relaciones);
    docenteServicio.guardarDocente(docente);

    status.setComplete();
    flash.addFlashAttribute("success", "El docente ha sido guardado exitosamente.");
    return "redirect:/docente/lista";
    }


    @GetMapping("/lista")
    public String listaDocentes(Model model) {
        model.addAttribute("docentes", docenteServicio.obtenerTodosLosDocentes());

        List<Docente> lista = docenteServicio.obtenerTodosLosDocentes();
        System.out.println("Cantidad de docentes: " + lista.size());
        return "docente/lista-docentes"; 
    }

    @GetMapping("/editar/{id}")
    public String editarDocente(@PathVariable int id, Model model) {
        Docente docente = docenteServicio.obtenerDocentePorId(id);
        System.out.println("Se mapeo el docente con ID: " + id);

        if (docente != null) {
            model.addAttribute("docente", docente);
            model.addAttribute("materias", materiaSerivicio.listarMaterias());
            return "docente/nuevo-docente"; 
        } else {
            model.addAttribute("error", "Docente no encontrado.");
            return "redirect:/docente/lista"; 
        }
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarDocente(@PathVariable int id, RedirectAttributes flash) {
        Docente docente = docenteServicio.obtenerDocentePorId(id);
        if (docente != null) {
            docenteServicio.eliminarDocente(id);
            flash.addFlashAttribute("success", "El docente ha sido eliminado exitosamente.");
        } else {
            flash.addFlashAttribute("error", "Docente no encontrado.");
        }
        return "redirect:/docente/lista"; 
    }


}
