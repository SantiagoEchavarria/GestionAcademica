package com.example.GestionAcademica.service.comportamiento;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.GestionAcademica.modelos.Comportamiento;
import com.example.GestionAcademica.repository.ComportamientoDAO;
@Service
public class ComportamientoServicio implements ComportamientoInterface {
   private final ComportamientoDAO comportamientoDAO;

public ComportamientoServicio(ComportamientoDAO comportamientoDAO) {
    this.comportamientoDAO = comportamientoDAO;
}

@Override
public List<Comportamiento> obtenerTodosLosComportamientos() {
    return comportamientoDAO.findAll();
}

@Override
public Comportamiento obtenerComportamientoPorId(int id) {
    return comportamientoDAO.findById(id).orElse(null);
}

@Override
public void guardarComportamiento(Comportamiento comportamiento) {
    comportamientoDAO.save(comportamiento);
}

@Override
public void eliminarComportamiento(int id) {
    comportamientoDAO.deleteById(id);
}

    
}
