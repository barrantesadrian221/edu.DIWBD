package edu.altair.bdDIW.entities;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "familias")
public class Familia {

    // 1. CLAVE PRIMARIA
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_familia")
    private Long idFamilia;

    // 2. DATOS DE LA MADRE
    @Column(name = "nombre_madre", length = 100)
    private String nombreMadre;

    @Column(name = "apellidos_madre", length = 150)
    private String apellidosMadre;

    @Column(name = "email_madre", length = 100)
    private String emailMadre;

    @Column(name = "telefono_madre", length = 20)
    private String telefonoMadre;

    @Column(name = "direccion_madre", length = 255)
    private String direccionMadre;

    @Column(name = "cp_madre", length = 10)
    private String cpMadre;

    @Column(name = "municipio_madre", length = 100)
    private String municipioMadre;

    @Column(name = "provincia_madre", length = 100)
    private String provinciaMadre;

    // 3. DATOS DEL PADRE
    @Column(name = "nombre_padre", length = 100)
    private String nombrePadre;

    @Column(name = "apellidos_padre", length = 150)
    private String apellidosPadre;

    @Column(name = "email_padre", length = 100)
    private String emailPadre;

    @Column(name = "telefono_padre", length = 20)
    private String telefonoPadre;

    @Column(name = "direccion_padre", length = 255)
    private String direccionPadre;

    @Column(name = "cp_padre", length = 10)
    private String cpPadre;

    @Column(name = "municipio_padre", length = 100)
    private String municipioPadre;

    @Column(name = "provincia_padre", length = 100)
    private String provinciaPadre;

    // 4. SITUACIÓN FAMILIAR
    @Column(name = "son_separados")
    private Boolean sonSeparados;

    @Column(name = "es_compartida")
    private Boolean esCompartida;

    @Column(name = "es_padre")
    private Boolean esPadre;

    @Column(name = "es_madre")
    private Boolean esMadre;

    //RELACION
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "Familia") private List<Alumno> alumnos;

    // 5. CONSTRUCTOR VACÍO (Obligatorio JPA)
    public Familia() {
    }

    // 6. CONSTRUCTOR COMPLETO
    public Familia(Long idFamilia, String nombreMadre, String apellidosMadre, String emailMadre, String telefonoMadre, String direccionMadre, String cpMadre, String municipioMadre, String provinciaMadre, String nombrePadre, String apellidosPadre, String emailPadre, String telefonoPadre, String direccionPadre, String cpPadre, String municipioPadre, String provinciaPadre, Boolean sonSeparados, Boolean esCompartida, Boolean esPadre, Boolean esMadre) {
        this.idFamilia = idFamilia;
        this.nombreMadre = nombreMadre;
        this.apellidosMadre = apellidosMadre;
        this.emailMadre = emailMadre;
        this.telefonoMadre = telefonoMadre;
        this.direccionMadre = direccionMadre;
        this.cpMadre = cpMadre;
        this.municipioMadre = municipioMadre;
        this.provinciaMadre = provinciaMadre;
        this.nombrePadre = nombrePadre;
        this.apellidosPadre = apellidosPadre;
        this.emailPadre = emailPadre;
        this.telefonoPadre = telefonoPadre;
        this.direccionPadre = direccionPadre;
        this.cpPadre = cpPadre;
        this.municipioMadre = municipioMadre;
        this.provinciaPadre = provinciaPadre;
        this.sonSeparados = sonSeparados;
        this.esCompartida = esCompartida;
        this.esPadre = esPadre;
        this.esMadre = esMadre;
    }

    // 7. GETTERS Y SETTERS
    public Long getIdFamilia() {
        return idFamilia;
    }

    public void setIdFamilia(Long idFamilia) {
        this.idFamilia = idFamilia;
    }

    public String getNombreMadre() {
        return nombreMadre;
    }

    public void setNombreMadre(String nombreMadre) {
        this.nombreMadre = nombreMadre;
    }

    public String getApellidosMadre() {
        return apellidosMadre;
    }

    public void setApellidosMadre(String apellidosMadre) {
        this.apellidosMadre = apellidosMadre;
    }

    public String getEmailMadre() {
        return emailMadre;
    }

    public void setEmailMadre(String emailMadre) {
        this.emailMadre = emailMadre;
    }

    public String getTelefonoMadre() {
        return telefonoMadre;
    }

    public void setTelefonoMadre(String telefonoMadre) {
        this.telefonoMadre = telefonoMadre;
    }

    public String getDireccionMadre() {
        return direccionMadre;
    }

    public void setDireccionMadre(String direccionMadre) {
        this.direccionMadre = direccionMadre;
    }

    public String getCpMadre() {
        return cpMadre;
    }

    public void setCpMadre(String cpMadre) {
        this.cpMadre = cpMadre;
    }

    public String getMunicipioMadre() {
        return municipioMadre;
    }

    public void setMunicipioMadre(String municipioMadre) {
        this.municipioMadre = municipioMadre;
    }

    public String getProvinciaMadre() {
        return provinciaMadre;
    }

    public void setProvinciaMadre(String provinciaMadre) {
        this.provinciaMadre = provinciaMadre;
    }

    public String getNombrePadre() {
        return nombrePadre;
    }

    public void setNombrePadre(String nombrePadre) {
        this.nombrePadre = nombrePadre;
    }

    public String getApellidosPadre() {
        return apellidosPadre;
    }

    public void setApellidosPadre(String apellidosPadre) {
        this.apellidosPadre = apellidosPadre;
    }

    public String getEmailPadre() {
        return emailPadre;
    }

    public void setEmailPadre(String emailPadre) {
        this.emailPadre = emailPadre;
    }

    public String getTelefonoPadre() {
        return telefonoPadre;
    }

    public void setTelefonoPadre(String telefonoPadre) {
        this.telefonoPadre = telefonoPadre;
    }

    public String getDireccionPadre() {
        return direccionPadre;
    }

    public void setDireccionPadre(String direccionPadre) {
        this.direccionPadre = direccionPadre;
    }

    public String getCpPadre() {
        return cpPadre;
    }

    public void setCpPadre(String cpPadre) {
        this.cpPadre = cpPadre;
    }

    public String getMunicipioPadre() {
        return municipioPadre;
    }

    public void setMunicipioPadre(String municipioPadre) {
        this.municipioPadre = municipioPadre;
    }

    public String getProvinciaPadre() {
        return provinciaPadre;
    }

    public void setProvinciaPadre(String provinciaPadre) {
        this.provinciaPadre = provinciaPadre;
    }

    public Boolean getSonSeparados() {
        return sonSeparados;
    }

    public void setSonSeparados(Boolean sonSeparados) {
        this.sonSeparados = sonSeparados;
    }

    public Boolean getEsCompartida() {
        return esCompartida;
    }

    public void setEsCompartida(Boolean esCompartida) {
        this.esCompartida = esCompartida;
    }

    public Boolean getEsPadre() {
        return esPadre;
    }

    public void setEsPadre(Boolean esPadre) {
        this.esPadre = esPadre;
    }

    public Boolean getEsMadre() {
        return esMadre;
    }

    public void setEsMadre(Boolean esMadre) {
        this.esMadre = esMadre;
    }

    // 8. EQUALS Y HASHCODE (Basados exclusivamente en la PK)
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Familia familia = (Familia) o;
        return Objects.equals(idFamilia, familia.idFamilia);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idFamilia);
    }
}
