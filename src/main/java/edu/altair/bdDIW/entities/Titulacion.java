package edu.altair.bdDIW.entities;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(
        name ="Titulacion",
        schema ="BDDIW",
        uniqueConstraints = {
                @UniqueConstraint(name = "uk_titulaciones_codigo", columnNames = "codigo"),
                @UniqueConstraint(name = "uk_titulaciones_diminutivo", columnNames = "diminutivo") } )


public class Titulacion {
        //CLAVE PRIMARIA
       @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id_titulacion")
        private Long id_titulacion;

        //ATRIBUTOS
        @Column(name = "codigo", nullable = false,length = 30)
        private String codigo;

        @Column(name = "diminutivo", nullable = false, length = 10)
        private String diminutivo;

        @Column(name = "horas_totales")
        private int horas_totales;


        //RELACION 1:N HACIA CURSO
        @OneToMany(fetch = FetchType.LAZY, mappedBy = "titulacion")private List<Curso> cursos;





    //Constructor vacio

        public Titulacion() {
        }

        //CONSTRUCTOR COMPLETO

        public Titulacion(Long id_titulacion, String codigo, String diminutivo, int horas_totales) {
                this.id_titulacion = id_titulacion;
                this.codigo = codigo;
                this.diminutivo = diminutivo;
                this.horas_totales = horas_totales;

        }

        //GETTERS Y SETTERS

        public Long getId_titulacion() {
                return id_titulacion;
        }

        public void setId_titulacion(Long id_titulacion) {
                this.id_titulacion = id_titulacion;
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

        public int getHoras_totales() {
                return horas_totales;
        }

        public void setHoras_totales(int horas_totales) {
                this.horas_totales = horas_totales;
        }

    public List<Curso> getCursos() {
        return cursos;
    }

    public void setCursos(List<Curso> cursos) {
        this.cursos = cursos;
    }

    //EQUALS Y HASHCODE
        @Override
        public boolean equals(Object o){
                if(this == o)return true;
                if(o == null || getClass() != o.getClass())return false;
                Titulacion titulacion = (Titulacion) o;
                return Objects.equals(id_titulacion, titulacion.id_titulacion);

        }
        @Override
        public int hashCode(){
                return Objects.hash(id_titulacion);
        }
}
