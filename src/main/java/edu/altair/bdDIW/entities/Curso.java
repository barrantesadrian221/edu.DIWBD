package edu.altair.bdDIW.entities;
import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity @Table( name = "cursos",
        schema = "BDDIW",
        uniqueConstraints = { @UniqueConstraint(name = "uk_cursos_diminutivo", columnNames = "diminutivo")
}
)

public class Curso {
    //CLAVE PRIMARIA
   @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_curso")
    private Long idCurso;

   //ATRIBUTOS PROPIOS
    @Column(name = "diminutivo", nullable = false, length = 15)
    private String diminutivo;
    @Column(name="descripcion",length = 250)
    private String descripcion;
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "curso")private List<Modulo_Curso> moduloCursos;
    
    //RELACION N:1 Varios cursos pertenecen a una titulacion
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_titulacion", nullable = false)
    private Titulacion titulacion;

//CONSTRUCTOR VACIO
    public Curso() {
    }
    //CONSTRUCTOR CON ATRIBUTOS

    public Curso(Long idCurso, String diminutivo, String descripcion, Titulacion titulacion) {
        this.idCurso = idCurso;
        this.diminutivo = diminutivo;
        this.descripcion = descripcion;
        this.titulacion = titulacion;
    }
    
    //GETTER Y SETTERS

    public Long getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(Long idCurso) {
        this.idCurso = idCurso;
    }

    public String getDiminutivo() {
        return diminutivo;
    }

    public void setDiminutivo(String diminutivo) {
        this.diminutivo = diminutivo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Titulacion getTitulacion() {
        return titulacion;
    }

    public void setTitulacion(Titulacion titulacion) {
        this.titulacion = titulacion;
    }
    //EQUALS Y HASHCODE (BASADOS EN ID_CURSO)

    @Override
    public boolean equals(Object o) {
        if(this == o)return true;
        if(o == null || getClass() != o.getClass())return false;
        Curso curso = (Curso) o;
        return Objects.equals(idCurso,curso.idCurso);
    }

    @Override public int hashCode() {
        return Objects.hash(idCurso); }
}
