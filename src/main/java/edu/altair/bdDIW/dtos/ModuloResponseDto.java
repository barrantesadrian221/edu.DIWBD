package edu.altair.bdDIW.dtos;

public record ModuloResponseDto(
        Long id_modulo,
        String codigo,
        String diminutivo,
        String nombre,
        String descripcion,
        int horas_Semanales,
        int creditos) {
}
