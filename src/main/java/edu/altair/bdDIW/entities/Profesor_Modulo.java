package edu.altair.bdDIW.entities;
import jakarta.persistence.*;
import java.util.Objects;
@Entity
@Table(
        name = "profesor_modulo",
        uniqueConstraints = {
                @UniqueConstraint(name = "uk_profesor_modulo", columnNames = {"id_profesor", "id_modulo"})        }
)
public class Profesor_Modulo {
    // 1. CLAVE PRIMARIA PROPIA
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_profesor_modulo")
    private Long idProfesorModulo;

    // 2. RELACIÓN N:1 HACIA PROFESOR (FK)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_profesor", nullable = false)
    private Profesor profesor;

    // 3. RELACIÓN N:1 HACIA MODULO (FK)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_modulo", nullable = false)
    private Modulo modulo;

    // 4. CONSTRUCTOR VACÍO (Obligatorio JPA)
    public Profesor_Modulo() {
    }

    // 5. CONSTRUCTOR COMPLETO
    public Profesor_Modulo(Long idProfesorModulo, Profesor profesor, Modulo modulo) {
        this.idProfesorModulo = idProfesorModulo;
        this.profesor = profesor;
        this.modulo = modulo;
    }

    // 6. GETTERS Y SETTERS
    public Long getIdProfesorModulo() {
        return idProfesorModulo;
    }

    public void setIdProfesorModulo(Long idProfesorModulo) {
        this.idProfesorModulo = idProfesorModulo;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    public Modulo getModulo() {
        return modulo;
    }

    public void setModulo(Modulo modulo) {
        this.modulo = modulo;
    }
}
