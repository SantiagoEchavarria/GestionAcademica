package com.example.GestionAcademica.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.GestionAcademica.modelos.Comportamiento;

@Repository
public interface ComportamientoDAO extends JpaRepository<Comportamiento, Integer> {
    
}
