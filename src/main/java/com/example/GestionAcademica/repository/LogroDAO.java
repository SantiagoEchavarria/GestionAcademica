package com.example.GestionAcademica.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.GestionAcademica.modelos.Logro;
@Repository
public interface LogroDAO extends JpaRepository<Logro, Integer> {

}
