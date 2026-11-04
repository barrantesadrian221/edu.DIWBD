package edu.altair.bdDIW.dtos;

public record ProfesorResponseDto(
       Long idProfesor,
        String dni,
        String nombre,
        String apellidos,
        String email_centro,
        String tlf_personal,
        Long idDepartamento) {
}
