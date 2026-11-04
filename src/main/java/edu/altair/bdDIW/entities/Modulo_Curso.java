package edu.altair.bdDIW.entities;
import jakarta.persistence.*;
import java.util.Objects;

@Entity
@Table(
        name = "modulos_cursos",
        uniqueConstraints = {
                @UniqueConstraint(name = "uk_modulo_curso", columnNames = {"id_modulo", "id_curso"})
        }
)
public class Modulo_Curso {

    // 1. CLAVE PRIMARIA PROPIA
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_modulo_curso")
    private Long idModuloCurso;

    // 2. RELACIÓN N:1 HACIA MODULO (FK)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_modulo", nullable = false)
    private Modulo modulo;

    // 3. RELACIÓN N:1 HACIA CURSO (FK)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_curso", nullable = false)
    private Curso curso;

    // 4. CONSTRUCTOR VACÍO (Obligatorio JPA)
    public Modulo_Curso() {
    }

    // 5. CONSTRUCTOR COMPLETO
    public Modulo_Curso(Long idModuloCurso, Modulo modulo, Curso curso) {
        this.idModuloCurso = idModuloCurso;
        this.modulo = modulo;
        this.curso = curso;
    }

    // 6. GETTERS Y SETTERS
    public Long getIdModuloCurso() {
        return idModuloCurso;
    }

    public void setIdModuloCurso(Long idModuloCurso) {
        this.idModuloCurso = idModuloCurso;
    }

    public Modulo getModulo() {
        return modulo;
    }

    public void setModulo(Modulo modulo) {
        this.modulo = modulo;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

}