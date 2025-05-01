package com.example.GestionAcademica.controllers;

import com.example.GestionAcademica.modelos.Grupo;
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
@RequestMapping("/grupo")
@SessionAttributes("grupo")
public class GrupoController {

    private final GrupoInterface grupoServicio;

    public GrupoController(GrupoInterface grupoServicio) {
        this.grupoServicio = grupoServicio;
    }

    // Mostrar formulario nuevo grupo
    @GetMapping("/nuevo")
    public String nuevoGrupo(Model model) {
        model.addAttribute("grupo", new Grupo());
        return "grupo/nuevo-grupo";
    }

    // Guardar grupo
    @PostMapping("/guardar")
    public String guardarGrupo(@Valid @ModelAttribute Grupo grupo,
                               BindingResult errors,
                               Model model,
                               RedirectAttributes flash,
                               SessionStatus status) {

        if (errors.hasErrors()) {
            model.addAttribute("errors", "Corrige los errores del formulario.");
            return "grupo/nuevo-grupo";
        }

        grupoServicio.guardarGrupo(grupo);
        status.setComplete();
        flash.addFlashAttribute("success", "Grupo guardado exitosamente.");
        return "redirect:/grupo/lista";
    }

    // Lista de grupos
    @GetMapping("/lista")
    public String listaGrupos(Model model) {
        List<Grupo> grupos = grupoServicio.obtenerTodosLosGrupos();
        model.addAttribute("grupos", grupos);
        return "grupo/lista-grupos";
    }

    // Consultar grupo
    @GetMapping("/consultar/{id}")
    public String consultarGrupo(@PathVariable int id, Model model) {
        Grupo grupo = grupoServicio.obtenerGrupoPorId(id);
        if (grupo != null) {
            model.addAttribute("grupo", grupo);
            return "grupo/consultar-grupo";
        }
        return "redirect:/grupo/lista";
    }

    // Editar grupo
    @GetMapping("/editar/{id}")
    public String editarGrupo(@PathVariable int id, Model model) {
        Grupo grupo = grupoServicio.obtenerGrupoPorId(id);
        if (grupo != null) {
            model.addAttribute("grupo", grupo);
            return "grupo/editar-grupo";
        }
        return "redirect:/grupo/lista";
    }

    // Eliminar grupo
    @GetMapping("/eliminar/{id}")
    public String eliminarGrupo(@PathVariable int id) {
        grupoServicio.eliminarGrupo(id);
        return "redirect:/grupo/lista";
    }
}

