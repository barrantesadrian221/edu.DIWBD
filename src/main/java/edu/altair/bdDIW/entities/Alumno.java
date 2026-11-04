package edu.altair.bdDIW.entities;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Entity
@Table(
        name = "alumnos",
        uniqueConstraints = {
                @UniqueConstraint(name = "uk_alumnos_dni", columnNames = "dni"),
                @UniqueConstraint(name = "uk_alumnos_numero_ss", columnNames = "numero_ss")
        }
)
public class Alumno {

    // 1. CLAVE PRIMARIA
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_alumno")
    private Long idAlumno;

    // 2. ATRIBUTOS PROPIOS
    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @Column(name = "apellidos", nullable = false, length = 150)
    private String apellidos;

    @Column(name = "dni", nullable = false, length = 20)
    private String dni;

    @Column(name = "numero_ss", length = 30)
    private String numeroSs;

    @Column(name = "email_personal", length = 100)
    private String emailPersonal;

    @Column(name = "telefono_personal", length = 20)
    private String telefonoPersonal;

    @Column(name = "fecha_alta", nullable = false)
    private LocalDate fechaAlta;

    @Column(name = "fecha_baja")
    private LocalDate fechaBaja;

    @Column(name = "email_centro", length = 100)
    private String emailCentro;

    // 3. RELACIÓN N:1 CON FAMILIA (FK id_familia)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_familia")
    private Familia familia;
//RELACION INTERMEDIA
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "Alumno")private List<Modulo_Estado_Alumno> moduloEstadoAlumnos;
    // 4. CONSTRUCTOR VACÍO (Obligatorio JPA)
    public Alumno() {
    }

    // 5. CONSTRUCTOR COMPLETO
    public Alumno(Long idAlumno, String nombre, String apellidos, String dni, String numeroSs, String emailPersonal, String telefonoPersonal, LocalDate fechaAlta, LocalDate fechaBaja, String emailCentro, Familia familia) {
        this.idAlumno = idAlumno;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dni = dni;
        this.numeroSs = numeroSs;
        this.emailPersonal = emailPersonal;
        this.telefonoPersonal = telefonoPersonal;
        this.fechaAlta = fechaAlta;
        this.fechaBaja = fechaBaja;
        this.emailCentro = emailCentro;
        this.familia = familia;
    }

    // 6. GETTERS Y SETTERS
    public Long getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(Long idAlumno) {
        this.idAlumno = idAlumno;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNumeroSs() {
        return numeroSs;
    }

    public void setNumeroSs(String numeroSs) {
        this.numeroSs = numeroSs;
    }

    public String getEmailPersonal() {
        return emailPersonal;
    }

    public void setEmailPersonal(String emailPersonal) {
        this.emailPersonal = emailPersonal;
    }

    public String getTelefonoPersonal() {
        return telefonoPersonal;
    }

    public void setTelefonoPersonal(String telefonoPersonal) {
        this.telefonoPersonal = telefonoPersonal;
    }

    public LocalDate getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(LocalDate fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public LocalDate getFechaBaja() {
        return fechaBaja;
    }

    public void setFechaBaja(LocalDate fechaBaja) {
        this.fechaBaja = fechaBaja;
    }

    public String getEmailCentro() {
        return emailCentro;
    }

    public void setEmailCentro(String emailCentro) {
        this.emailCentro = emailCentro;
    }

    public Familia getFamilia() {
        return familia;
    }

    public void setFamilia(Familia familia) {
        this.familia = familia;
    }

    // 7. EQUALS Y HASHCODE (Basados en la PK)
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Alumno alumno = (Alumno) o;
        return Objects.equals(idAlumno, alumno.idAlumno);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idAlumno);
    }
}
