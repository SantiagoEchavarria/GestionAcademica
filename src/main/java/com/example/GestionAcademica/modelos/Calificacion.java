package com.example.GestionAcademica.modelos;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "calificaciones")
public class Calificacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull(message = "La nota no puede ser nula")
    @DecimalMin(value = "0.0", inclusive = true, message = "La nota no puede ser menor que 0")
    @DecimalMax(value = "5.0", inclusive = true, message = "La nota no puede ser mayor que 5")
    @Column(name = "nota", nullable = false)
    private float nota;

    @NotBlank(message = "El periodo no puede estar vacío")
    @Column(name = "periodo", nullable = false, length = 20)
    private String periodo;

    @ManyToOne
    @JoinColumn(name = "alumno_id", nullable = false)
    private Alumno alumno;

    @ManyToOne
    @JoinColumn(name = "materia_id", nullable = false)
    private Materia materia;


    // Constructor vacío requerido por JPA
    public Calificacion() {
    }

    // Constructor con argumentos
    public Calificacion(Materia materia, float nota, String periodo, Alumno alumno) {
        this.materia = materia;
        this.nota = nota;
        this.periodo = periodo;
        this.alumno = alumno;
       
    }

    // Getters y Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getNota() {
        return nota;
    }

    public void setNota(float nota) {
        this.nota = nota;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }
    public Materia getMateria() {
        return materia;
    }
    public void setMateria(Materia materia) {
        this.materia = materia;
    }
}


