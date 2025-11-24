package com.example.GestionAcademica.modelos;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "materias")
public class Materia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "{materia.nombre.notblank}")
    @Size(min = 2, max = 50, message = "{materia.nombre.size}")
    @Pattern(regexp = "^[A-Za-záéíóúÁÉÍÓÚñÑ ]+$", message = "{materia.nombre.pattern}")
    @Column(name = "nombre", nullable = false, length = 50, unique = true)
    private String nombre;

    @NotBlank(message = "{materia.area.notblank}")
    @Size(min = 2, max = 50, message = "{materia.area.size}")
    @Pattern(regexp = "^[A-Za-záéíóúÁÉÍÓÚñÑ ]+$", message = "{materia.area.pattern}")
    @Column(name = "area", nullable = false, length = 50)
    private String area;

    @ManyToOne(optional = false)
    @JoinColumn(name = "docente_id", nullable = false)
    @NotNull(message = "{materia.docente.notnull}")
    private Docente docente;

    // Constructor vacío (obligatorio para JPA)
    public Materia() {}

    // Constructor con parámetros
    public Materia(String nombre, String area, Docente docente) {
        this.nombre = nombre;
        this.area = area;
        this.docente = docente;
    }

    // Getters y Setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public Docente getDocente() {
        return docente;
    }

    public void setDocente(Docente docente) {
        this.docente = docente;
    }

    // Método toString
    @Override
    public String toString() {
        return "Materia{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", area='" + area + '\'' +
                ", docente=" + docente +
                '}';
    }
}

