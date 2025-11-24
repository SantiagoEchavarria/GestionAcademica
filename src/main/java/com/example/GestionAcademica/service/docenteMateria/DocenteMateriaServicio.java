package com.example.GestionAcademica.service.docenteMateria;

import java.util.List;

import com.example.GestionAcademica.modelos.DocenteMateria;
import com.example.GestionAcademica.repository.DocenteMateriaDAO;

import jakarta.transaction.Transactional;

public class DocenteMateriaServicio implements DocenteMateriaInterface {
    private final DocenteMateriaDAO docenteMateriaDAO;
    

    public DocenteMateriaServicio(DocenteMateriaDAO docenteMateriaDAO) {
        this.docenteMateriaDAO = docenteMateriaDAO;
    }

    @Override
    public List<DocenteMateria> obtenerTodosLosDocentesMaterias() {
        return docenteMateriaDAO.findAll();
    }

    @Override
    @Transactional
    public void guardarDocenteMateria(DocenteMateria docenteMateria) {
        docenteMateriaDAO.save(docenteMateria);
    }

    @Override
    public DocenteMateria obtenerDocenteMateriaPorId(Long id) {
        return docenteMateriaDAO.findById(id).orElse(null);
    }
    
}
