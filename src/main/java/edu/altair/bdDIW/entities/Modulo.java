package edu.altair.bdDIW.entities;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name="modulo",schema = "BDDIW",
uniqueConstraints = {
        @UniqueConstraint(name="uk_modulo_codigo", columnNames = "codigo"),
        @UniqueConstraint(name="uk_modulo_diminutivo", columnNames = "diminutivo")
})
public class Modulo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_modulo;

    @Column(name = "codigo", nullable = false, length = 14)
    private String codigo;

    @Column(name = "diminutivo", nullable = false, length = 15)
    private String diminutivo;

    @Column(name = "nombre", nullable = false,  length= 30)
    private String nombre;

    @Column(name="descripcion", length = 300)
    private String descripcion;

    @Column(name="horas_Semanales")
    private int horas_Semanales;

    @Column(name="creditos")
    private int creditos;
//RELACION A LAS TABLAS INTERMEDIAS
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "Modulo")private List<Modulo_Curso> moduloCursos;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "Modulo")private List<Profesor_Modulo> profesorModulos;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "Modulo")private List<Modulo_Estado_Alumno> moduloEstadoAlumnos;
    //CONSTRUCTOR VACIO

    public Modulo() {
    }

    //CONSTRUCTOR

    public Modulo(Long id_modulo, String codigo, String diminutivo, String nombre, String descripcion, int horas_Semanales, int creditos) {
        this.id_modulo = id_modulo;
        this.codigo = codigo;
        this.diminutivo = diminutivo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.horas_Semanales = horas_Semanales;
        this.creditos = creditos;
    }

    //GETTER Y SETTER

    public Long getId_modulo() {
        return id_modulo;
    }

    public void setId_modulo(Long id_modulo) {
        this.id_modulo = id_modulo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDiminutivo() {
        return diminutivo;
    }

    public void setDiminutivo(String diminutivo) {
        this.diminutivo = diminutivo;
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

    public int getHoras_Semanales() {
        return horas_Semanales;
    }

    public void setHoras_Semanales(int horas_Semanales) {
        this.horas_Semanales = horas_Semanales;
    }

    public int getCreditos() {
        return creditos;
    }

    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }

    public List<Modulo_Curso> getModuloCursos() {
        return moduloCursos;
    }

    public void setModuloCursos(List<Modulo_Curso> moduloCursos) {
        this.moduloCursos = moduloCursos;
    }

    public List<Modulo_Estado_Alumno> getModuloEstadoAlumnos() {
        return moduloEstadoAlumnos;
    }

    public void setModuloEstadoAlumnos(List<Modulo_Estado_Alumno> moduloEstadoAlumnos) {
        this.moduloEstadoAlumnos = moduloEstadoAlumnos;
    }

    public List<Profesor_Modulo> getProfesorModulos() {
        return profesorModulos;
    }

    public void setProfesorModulos(List<Profesor_Modulo> profesorModulos) {
        this.profesorModulos = profesorModulos;
    }
}
