package edu.altair.bdDIW.dtos;

public record DepartamentoResponseDto(
        Long idDepartamento,
        Integer codigo,
        String nombre,
        String descripcion,
        String telefono ) {}