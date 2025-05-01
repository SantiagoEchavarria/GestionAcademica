package com.example.GestionAcademica.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.GestionAcademica.modelos.Calificacion;

@Repository
public interface CalificacionDAO extends JpaRepository<Calificacion, Integer> {    
}
