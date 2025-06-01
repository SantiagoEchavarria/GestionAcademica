package com.example.GestionAcademica.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.GestionAcademica.modelos.Docente;

@Repository
public interface DocenteDAO extends JpaRepository<Docente, Integer> {
    
}
