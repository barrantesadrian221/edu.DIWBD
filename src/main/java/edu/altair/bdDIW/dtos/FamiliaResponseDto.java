package edu.altair.bdDIW.dtos;

public record FamiliaResponseDto(
        long idFamilia,
        Stringtring nombreMadre,
        String apellidosMadre,
        String emailMadre,
        String telefonoMadre,
        String direccionMadre,
        String cpMadre,
        String municipioMadre,
        String provinciaMadre,
        String nombrePadre,
        String apellidosPadre,
        String emailPadre,
        String telefonoPadre,
        String direccionPadre,
        String cpPadre,
        String municipioPadre,
        String provinciaPadre,
        Boolean sonSeparados,
        Boolean esCompartida,
        Boolean esPadre,
        Boolean esMadre
        ) {
}
