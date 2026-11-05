package edu.altair.bdDIW.services;

import edu.altair.bdDIW.dtos.AlumnoRequestDto;
import edu.altair.bdDIW.dtos.AlumnoResponseDto;
import org.apache.coyote.BadRequestException;

import java.util.List;

public interface AlumnoService {
    List<AlumnoResponseDto> listarTodosLosAlumnos();

    AlumnoResponseDto buscarAlumnoPorId(Long id_alumno);
    AlumnoResponseDto buscarAlumnoPorDni(String dni);

    AlumnoResponseDto crearAlumno (AlumnoRequestDto crear) throws BadRequestException;
    AlumnoResponseDto actualizarAlumnoPorId(Long id_alumno, AlumnoRequestDto datos_actualizados);
    AlumnoResponseDto actualizarAlumnoPorDni ( String dni, AlumnoRequestDto datos_actualizados);

    void elminarAlumnoPorId (Long id_alumno);
    void eliminarAlumnoPorDni (String dni);
}
