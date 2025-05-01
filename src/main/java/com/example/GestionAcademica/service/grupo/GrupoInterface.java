package com.example.GestionAcademica.service.grupo;

import java.util.List;

import com.example.GestionAcademica.modelos.Grupo;

public interface GrupoInterface {
    List<Grupo> obtenerTodosLosGrupos();
    Grupo obtenerGrupoPorId(int id);
    void guardarGrupo(Grupo grupo);
    void eliminarGrupo(int id);
}
