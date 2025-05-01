package com.example.GestionAcademica.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.GestionAcademica.modelos.Alumno;
import org.springframework.stereotype.Repository;

@Repository
public interface AlumnoDAO extends JpaRepository<Alumno, Integer> {
  
}
