package edu.altair.bdDIW.dtos;

public record ModuloRequestDto(
        String codigo,
        String diminutivo,
        String nombre,
        String descripcion,
        int horas_Semanales,
        int creditos
) {
}
