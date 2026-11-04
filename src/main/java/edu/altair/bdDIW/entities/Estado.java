package edu.altair.bdDIW.entities;
import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "estado")



public class Estado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_estado")
    private Long id_Estado;

    //ATRIBUTOS
    @Column(name="nombre", nullable = false, length = 30)
    private String nombre;


    @Column(name="descripcion", length = 300)
    private String descripcion;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "Estado")private List<Modulo_Estado_Alumno> moduloEstadoAlumnos;

    //CONTRUCTOR VACIO

    public Estado() {
    }

    //CONSTRUCTOR COMPLETO

    public Estado(Long id_Estado, String nombre, String descripcion) {
        this.id_Estado = id_Estado;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    //GETTER Y SETTERS

    public Long getId_Estado() {
        return id_Estado;
    }

    public void setId_Estado(Long id_Estado) {
        this.id_Estado = id_Estado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<Modulo_Estado_Alumno> getModuloEstadoAlumnos() {
        return moduloEstadoAlumnos;
    }

    public void setModuloEstadoAlumnos(List<Modulo_Estado_Alumno> moduloEstadoAlumnos) {
        this.moduloEstadoAlumnos = moduloEstadoAlumnos;
    }
    //EQUALS Y HASHCODE

    @Override public boolean equals(Object o)
    { if (this == o) return true; if (o == null || getClass() != o.getClass()) return false;
        Estado estado = (Estado) o;
        return Objects.equals(id_Estado, estado.id_Estado); }
    @Override public int hashCode() { return Objects.hash(id_Estado); } }
