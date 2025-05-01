package com.example.GestionAcademica.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.GestionAcademica.modelos.Asistencia;

@Repository
public interface AsistenciaDAO extends JpaRepository<Asistencia, Integer> {
 
} 
