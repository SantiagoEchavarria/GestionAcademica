package com.example.GestionAcademica.modelos;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;

import java.util.Date;

@Entity
@Table(name = "comportamientos")
public class Comportamiento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull(message = "La fecha no puede ser nula")
    @PastOrPresent(message = "La fecha debe ser pasada o actual")
    @Temporal(TemporalType.DATE)
    @Column(name = "fecha", nullable = false)
    private Date fecha;

    @NotBlank(message = "La descripción no puede estar vacía")
    @Column(name = "descripcion", nullable = false, length = 255)
    private String descripcion;

    @NotBlank(message = "El tipo de comportamiento no puede estar vacío")
    @Column(name = "tipo", nullable = false, length = 10)
    private String tipo;

    @ManyToOne
    @JoinColumn(name = "alumno_id", nullable = false)
    private Alumno alumno;

    // Constructor vacío requerido por JPA
    public Comportamiento() {
    }

    // Constructor completo
    public Comportamiento(Date fecha, String descripcion, String tipo, Alumno alumno) {
        this.fecha = fecha;
        this.descripcion = descripcion;
        this.tipo = tipo;
        this.alumno = alumno;
    }

    // Getters y Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }
}
