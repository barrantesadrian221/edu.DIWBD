package edu.altair.bdDIW.dtos;

public record CursoRequestDto(
        String diminutivo,
        String descripcion,
        Long idTitulacion
) {
}
