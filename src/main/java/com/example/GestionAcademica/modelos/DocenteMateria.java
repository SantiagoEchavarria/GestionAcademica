package com.example.GestionAcademica.modelos;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "docente_materia")
public class DocenteMateria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "docente_id", nullable = false)
    @NotNull(message = "{docentemateria.docente.notnull}")
    private Docente docente;

    @ManyToOne
    @JoinColumn(name = "materia_id", nullable = false)
    @NotNull(message = "{docentemateria.materia.notnull}")
    private Materia materia;

    @Column(name = "fecha_inicio", nullable = false)
    private LocalDate fechaInicio;

    @Column(name = "fecha_fin")
    private LocalDate fechaFin;

    @PrePersist
    protected void onCreate() {
        this.fechaInicio = LocalDate.now();
    }

    public DocenteMateria(Long id, Docente docente, Materia materia, LocalDate fechaInicio, LocalDate fechaFin) {
        this.id = id;
        this.docente = docente;
        this.materia = materia;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    public DocenteMateria() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Docente getDocente() {
        return docente;
    }

    public void setDocente(Docente docente) {
        this.docente = docente;
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    @Override
    public String toString() {
        return "DocenteMateria [id=" + id + ", docente=" + docente + ", materia=" + materia + ", fechaInicio="
                + fechaInicio + ", fechaFin=" + fechaFin + "]";
    }

    
}
