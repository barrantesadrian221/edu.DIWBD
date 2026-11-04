package edu.altair.bdDIW.entities;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "Departamento",
schema="BDDIW",
    uniqueConstraints =  {
        @UniqueConstraint(name = "codigo_departamento",columnNames = "codigo")
        }
)

public class Departamento {
    //CLAVE PRIMARIA
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_departamento")
    private Long id_departamento;


    //ATRIBUTOS
    @Column(name = "codigo",nullable = false)
    private int codigo;

    @Column(name="nombre", nullable = false)
    private String nombre;

    @Column(name="descripcion" ,length = 300)
    private String descripcion;

    @Column(name = "telefono", length = 15)
    private String telefono;

    // RELACION 1:N
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "departamento")private List<Profesor> profesor;
    // CONSTRUCTOR VACIO

    public Departamento() {
    }

    //CONSTRUCTOR COMPLETO

    public Departamento(Long id_departamento, String telefono, String descripcion, String nombre, int codigo) {
        this.id_departamento = id_departamento;
        this.telefono = telefono;
        this.descripcion = descripcion;
        this.nombre = nombre;
        this.codigo = codigo;
    }

    //GETTER Y SETTERS

    public Long getId_departamento() {
        return id_departamento;
    }

    public void setId_departamento(Long id_departamento) {
        this.id_departamento = id_departamento;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public List<Profesor> getProfesor() {
        return profesor;
    }

    public void setProfesor(List<Profesor> profesor) {
        this.profesor = profesor;
    }
}
