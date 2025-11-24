package com.example.GestionAcademica.service.docenteMateria;

import java.util.List;

import com.example.GestionAcademica.modelos.DocenteMateria;

public interface DocenteMateriaInterface {
    List<DocenteMateria> obtenerTodosLosDocentesMaterias();
    void guardarDocenteMateria(DocenteMateria docenteMateria);
    DocenteMateria obtenerDocenteMateriaPorId(Long id);
}
