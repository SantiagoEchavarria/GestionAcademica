package com.example.GestionAcademica.service.comportamiento;

import java.util.List;

import com.example.GestionAcademica.modelos.Comportamiento;

public interface ComportamientoInterface {
    List<Comportamiento> obtenerTodosLosComportamientos();
    Comportamiento obtenerComportamientoPorId(int id);
    void guardarComportamiento(Comportamiento comportamiento);
    void eliminarComportamiento(int id);
}
