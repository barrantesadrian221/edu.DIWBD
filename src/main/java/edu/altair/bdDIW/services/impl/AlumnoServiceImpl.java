package edu.altair.bdDIW.services.impl;

import edu.altair.bdDIW.dtos.AlumnoRequestDto;
import edu.altair.bdDIW.dtos.AlumnoResponseDto;
import edu.altair.bdDIW.entities.Alumno;
import edu.altair.bdDIW.entities.Familia;
import edu.altair.bdDIW.exceptions.ResourceNotFounException;
import edu.altair.bdDIW.repositories.AlumnoRepository;
import edu.altair.bdDIW.repositories.FamiliaRepository;
import edu.altair.bdDIW.services.AlumnoService;

import org.apache.coyote.BadRequestException;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AlumnoServiceImpl implements AlumnoService {

    private final AlumnoRepository alumnoRepository;
    private final FamiliaRepository familiaRepository;
    // Inyección de dependencias por constructor
    public AlumnoServiceImpl(AlumnoRepository alumnoRepository, FamiliaRepository familiaRepository, FamiliaRepository familiaRepository1) {
        this.alumnoRepository = alumnoRepository;
        this.familiaRepository = familiaRepository;
    }

    //METODO LISTAR TODOS LOS ALUMNOS
    @Override
    @Transactional(readOnly = true)
    public List<AlumnoResponseDto> listarTodosLosAlumnos() {
        return alumnoRepository.findAll()
                .stream()
                .map(this::mapToResponseDto)
                .toList(); // Método toList() optimizado en Java 25
    }

    //BUSQUEDA POR PARAMETRO
    @Override
    @Transactional(readOnly = true)
    public AlumnoResponseDto buscarAlumnoPorId(Long id) {
        Alumno alumno = alumnoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFounException("Alumno no encontrado con el ID: " + id));
        return mapToResponseDto(alumno);
    }

    @Override
    @Transactional(readOnly = true)
    public AlumnoResponseDto buscarAlumnoPorDni(String dni) {
        Alumno alumno = alumnoRepository.findByDni(dni)
                .orElseThrow(() -> new ResourceNotFounException("Alumno no encontrado con el DNI: " + dni));
        return mapToResponseDto(alumno);
    }

    @Override
    public AlumnoResponseDto crearAlumno(AlumnoRequestDto crear) throws BadRequestException {
        if(alumnoRepository.existsByDni(crear.dni())){
            throw new BadRequestException("Ya existe un alumno con el DNI: " + crear.dni());
        }
        //CREAR OBJETO ENTIDAD
        Alumno alumno = new Alumno();
        alumno.setNombre(crear.nombre());
        alumno.setApellidos(crear.apellidos());
        alumno.setDni(crear.dni());
        alumno.setEmailCentro(crear.email_centro());
        alumno.setEmailPersonal(crear.email_personal());
        alumno.setFechaAlta(crear.fecha_alta());
        alumno.setFechaBaja(crear.fecha_baja());
        alumno.setNumeroSs(crear.numero_ss());
        alumno.setTelefonoPersonal(String.valueOf(crear.tlf_personal()));
        //ASIGNAR ID DE FAMILIA OPCIONAL
        if(crear.id_familia() != null) {
            Familia familia = familiaRepository.findById(Long.valueOf(crear.id_familia()))
                    .orElseThrow(() -> new ResourceNotFounException("Familia no encontrada con ID: "+crear.id_familia()));
        alumno.setFamilia(familia);
        }
Alumno guardado = alumnoRepository.save(alumno);
        return mapToResponseDto(guardado);
    }

    @Override
    public AlumnoResponseDto actualizarAlumnoPorId(Long id_alumno, AlumnoRequestDto datos_actualizados) {
       Alumno alumno = alumnoRepository.findById(id_alumno)
               .orElseThrow(()-> new ResourceNotFounException("Alumno no encontrado con id" + id_alumno));
       actualizarCampos(alumno, datos_actualizados);


        return mapToResponseDto(alumnoRepository.save(alumno));
    }



    @Override
    public AlumnoResponseDto actualizarAlumnoPorDni(String dni, AlumnoRequestDto datos_actualizados) {
        return null;
    }

    @Override
    public void elminarAlumnoPorId(Long id_alumno) {

    }

    @Override
    public void eliminarAlumnoPorDni(String dni) {

    }

    // METODO AUXILIAR

    private void actualizarCampos(Alumno alumno, AlumnoRequestDto datosActualizados) {
    }
    private AlumnoResponseDto mapToResponseDto(Alumno entity) {
        return new AlumnoResponseDto(
                entity.getIdAlumno(),
                entity.getNombre(),
                entity.getApellidos(),
                entity.getDni(),
                entity.getNumeroSs(),
                entity.getEmailPersonal(),
                entity.getTelefonoPersonal(),
                entity.getFechaAlta(),
                entity.getFechaBaja(),
                entity.getEmailCentro(),
                entity.getFamilia() != null ? entity.getFamilia().getIdFamilia() : null
        );
    }

}
