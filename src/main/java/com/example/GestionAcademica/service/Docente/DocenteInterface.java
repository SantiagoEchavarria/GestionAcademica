package com.example.GestionAcademica.service.Docente;

import java.util.List;

import com.example.GestionAcademica.modelos.Docente;

public interface DocenteInterface {
    List<Docente> obtenerTodosLosDocentes();
    Docente obtenerDocentePorId(int id);
    void guardarDocente(Docente docente);
    void eliminarDocente(int id);
    
}
