package edu.altair.bdDIW.dtos;

public record CursoResponseDto(
        Long id_curso,
        String diminutivo,
        String descripcion,
        Long idTitulacion) {
}
