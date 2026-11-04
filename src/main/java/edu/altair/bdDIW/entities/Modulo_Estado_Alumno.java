package edu.altair.bdDIW.entities;

import jakarta.persistence.*;

@Entity
@Table(
        name = "alumno_modulo_estado",
        uniqueConstraints = {
                @UniqueConstraint(name = "uk_alumno_modulo_estado", columnNames = {"id_alumno", "id_modulo", "id_estado"})
        }
)
public class Modulo_Estado_Alumno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_alumno_modulo_estado")
    private Long idAlumnoModuloEstado;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_alumno", nullable = false)
    private Alumno alumno;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_modulo", nullable = false)
    private Modulo modulo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_estado", nullable = false)
    private Estado estado;

    public Modulo_Estado_Alumno() {
    }

    public Modulo_Estado_Alumno(Long idAlumnoModuloEstado, Alumno alumno, Modulo modulo, Estado estado) {
        this.idAlumnoModuloEstado = idAlumnoModuloEstado;
        this.alumno = alumno;
        this.modulo = modulo;
        this.estado = estado;
    }

    public Long getIdAlumnoModuloEstado() {
        return idAlumnoModuloEstado;
    }

    public void setIdAlumnoModuloEstado(Long idAlumnoModuloEstado) {
        this.idAlumnoModuloEstado = idAlumnoModuloEstado;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public Modulo getModulo() {
        return modulo;
    }

    public void setModulo(Modulo modulo) {
        this.modulo = modulo;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }
}
