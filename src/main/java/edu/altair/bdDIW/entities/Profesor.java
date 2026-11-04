package edu.altair.bdDIW.entities;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
@Table(
        name = "profesores",
        schema = "BDDIW",
        uniqueConstraints = {
                @UniqueConstraint(name = "uk_profesores_dni",columnNames = "dni")
        }
)


public class Profesor {
    //CLAVE PRIMARIA
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_profesor")
    private Long idProfesor;

@Column(name = "dni", nullable = false, length = 9)
    private String dni;


@Column(name="nombre", nullable = false, length = 50)
    private String nombre;

@Column (name= "apellidos", nullable = false, length = 130)
    private String apellidos;

@Column(name = "email_centro", length = 100)
    private String email_centro;

@Column(name="tlf_personal", length = 15)
    private String tlf_personal;


//RELACION N:1(VARIOS PROFESORES PERTENECEN A UN DEPARTAMENTO)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_departamento",nullable = false)
    private Departamento departamento;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "profesor")private List<Profesor_Modulo> profesorModulos;

//CONSTRUCTOR VACIO
    public Profesor(){

    }
    //CONSTRUCTOR COMPLETO


    public Profesor(String dni, Long idProfesor, String nombre, String apellidos, String email_centro, String tlf_personal, Departamento departamento) {
        this.dni = dni;
        this.idProfesor = idProfesor;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.email_centro = email_centro;
        this.tlf_personal = tlf_personal;
        this.departamento = departamento;
    }
    //GETTERS Y SETTERS


    public Long getIdProfesor() {
        return idProfesor;
    }

    public void setIdProfesor(Long idPRofesor) {
        this.idProfesor = idPRofesor;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail_centro() {
        return email_centro;
    }

    public void setEmail_centro(String email_centro) {
        this.email_centro = email_centro;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getTlf_personal() {
        return tlf_personal;
    }

    public void setTlf_personal(String tlf_personal) {
        this.tlf_personal = tlf_personal;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public List<Profesor_Modulo> getProfesorModulos() {
        return profesorModulos;
    }

    public void setProfesorModulos(List<Profesor_Modulo> profesorModulos) {
        this.profesorModulos = profesorModulos;
    }
    //EQUALS Y HASHCODE

    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        Profesor profesor = (Profesor) o;
    return Objects.equals(idProfesor,profesor.idProfesor);
    }

    @Override
    public int hashCode (){
        return Objects.hash(idProfesor);
    }
}


