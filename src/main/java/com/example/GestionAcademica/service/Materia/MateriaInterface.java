package com.example.GestionAcademica.service.Materia;

import java.util.List;

import com.example.GestionAcademica.modelos.Materia;

public interface MateriaInterface {
    List<Materia> listarMaterias();
    Materia obtenerMateriaPorId(int materiaId);
    void guardarMateria(Materia materia);
    void actualizarMateria(int id, Materia materia);
    void eliminarMateria(int id);
}
