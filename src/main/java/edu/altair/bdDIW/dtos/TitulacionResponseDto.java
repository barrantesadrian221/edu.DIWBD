package edu.altair.bdDIW.dtos;

public record TitulacionResponseDto(
        Long id_titulacion,
        String codigo,
        String diminutivo,
        int horas_totales) {
}
