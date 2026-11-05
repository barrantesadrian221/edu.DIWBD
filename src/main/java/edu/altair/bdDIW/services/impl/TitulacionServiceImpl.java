package edu.altair.bdDIW.services.impl;

import edu.altair.bdDIW.dtos.TitulacionRequestDto;
import edu.altair.bdDIW.dtos.TitulacionResponseDto;
import edu.altair.bdDIW.entities.Titulacion;
import edu.altair.bdDIW.exceptions.BadRequestException;
import edu.altair.bdDIW.exceptions.ResourceNotFoundException;
import edu.altair.bdDIW.repositories.TitulacionRepository;
import edu.altair.bdDIW.services.TitulacionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TitulacionServiceImpl implements TitulacionService {

    private final TitulacionRepository titulacionRepository;

    // Inyección de dependencias por constructor
    public TitulacionServiceImpl(TitulacionRepository titulacionRepository) {
        this.titulacionRepository = titulacionRepository;
    }

    // =========================================================
    // 1. LECTURAS (GET)
    // =========================================================
    @Override
    @Transactional(readOnly = true)
    public List<TitulacionResponseDto> listarTodasLasTitulaciones() {
        return titulacionRepository.findAll()
                .stream()
                .map(this::mapToResponseDto)
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public TitulacionResponseDto buscarTitulacionPorId(Long idTitulacion) {
        Titulacion titulacion = titulacionRepository.findById(idTitulacion)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Titulación no encontrada con ID: " + idTitulacion
                        )
                );
        return mapToResponseDto(titulacion);
    }

    @Override
    @Transactional(readOnly = true)
    public TitulacionResponseDto buscarTitulacionPorCodigo(String codigo) {
        Titulacion titulacion = titulacionRepository.findByCodigo(codigo)
                .orElseThrow(() -> new ResourceNotFoundException(
                                "Titulación no encontrada con código: " + codigo
                        )
                );
        return mapToResponseDto(titulacion);
    }

    @Override
    @Transactional(readOnly = true)
    public TitulacionResponseDto buscarTitulacionPorDiminutivo(String diminutivo) {
        Titulacion titulacion = titulacionRepository.findByDiminutivo(diminutivo)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Titulación no encontrada con diminutivo: " + diminutivo
                        )
                );
        return mapToResponseDto(titulacion);
    }

    // =========================================================
    // 2. CREACIÓN (POST)
    // =========================================================
    @Override
    @Transactional
    public TitulacionResponseDto crearTitulacion(TitulacionRequestDto crear) throws BadRequestException {
        if (titulacionRepository.existsByCodigo(crear.codigo())) {
            throw new BadRequestException(
                    "Ya existe una titulación registrada con el código: " + crear.codigo()
            );
        }
        if (titulacionRepository.existsByDiminutivo(crear.diminutivo())) {
            throw new BadRequestException(
                    "Ya existe una titulación registrada con el diminutivo: " + crear.diminutivo()
            );
        }

        Titulacion titulacion = new Titulacion();
        titulacion.setCodigo(crear.codigo());
        titulacion.setDiminutivo(crear.diminutivo());
        titulacion.setHoras_totales(crear.horas_totales());

        Titulacion guardada = titulacionRepository.save(titulacion);
        return mapToResponseDto(guardada);
    }

    // =========================================================
    // 3. ACTUALIZACIÓN (PUT)
    // =========================================================
    @Override
    @Transactional
    public TitulacionResponseDto actualizarTitulacionPorId(
            Long idTitulacion,
            TitulacionRequestDto datosActualizados) throws BadRequestException {

        Titulacion titulacionExistente = titulacionRepository.findById(idTitulacion)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Titulación no encontrada con ID: " + idTitulacion
                        )
                );

        validarUnicidadEnActualizacion(titulacionExistente, datosActualizados);

        titulacionExistente.setCodigo(datosActualizados.codigo());
        titulacionExistente.setDiminutivo(datosActualizados.diminutivo());
        titulacionExistente.setHoras_totales(datosActualizados.horas_totales());

        Titulacion actualizada = titulacionRepository.save(titulacionExistente);
        return mapToResponseDto(actualizada);
    }

    @Override
    @Transactional
    public TitulacionResponseDto actualizarTitulacionPorCodigo(
            String codigo,
            TitulacionRequestDto datosActualizados) throws BadRequestException {

        Titulacion titulacionExistente = titulacionRepository.findByCodigo(codigo)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Titulación no encontrada con código: " + codigo
                        )
                );

        validarUnicidadEnActualizacion(titulacionExistente, datosActualizados);

        titulacionExistente.setCodigo(datosActualizados.codigo());
        titulacionExistente.setDiminutivo(datosActualizados.diminutivo());
        titulacionExistente.setHoras_totales(datosActualizados.horas_totales());

        Titulacion actualizada = titulacionRepository.save(titulacionExistente);
        return mapToResponseDto(actualizada);
    }

    @Override
    @Transactional
    public TitulacionResponseDto actualizarTitulacionPorDiminutivo(
            String diminutivo,
            TitulacionRequestDto datosActualizados) throws BadRequestException {

        Titulacion titulacionExistente = titulacionRepository.findByDiminutivo(diminutivo)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Titulación no encontrada con diminutivo: " + diminutivo
                        )
                );

        validarUnicidadEnActualizacion(titulacionExistente, datosActualizados);

        titulacionExistente.setCodigo(datosActualizados.codigo());
        titulacionExistente.setDiminutivo(datosActualizados.diminutivo());
        titulacionExistente.setHoras_totales(datosActualizados.horas_totales());

        Titulacion actualizada = titulacionRepository.save(titulacionExistente);
        return mapToResponseDto(actualizada);
    }

    // =========================================================
    // 4. ELIMINACIÓN (DELETE)
    // =========================================================
    @Override
    @Transactional
    public void eliminarTitulacionPorId(Long idTitulacion) {
        if (!titulacionRepository.existsById(idTitulacion)) {
            throw new ResourceNotFoundException(
                    "Titulación no encontrada con ID: " + idTitulacion
            );
        }
        titulacionRepository.deleteById(idTitulacion);
    }

    @Override
    @Transactional
    public void eliminarTitulacionPorCodigo(String codigo) {
        Titulacion titulacion = titulacionRepository.findByCodigo(codigo)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Titulación no encontrada con código: " + codigo
                        )
                );
        titulacionRepository.delete(titulacion);
    }

    @Override
    @Transactional
    public void eliminarTitulacionPorDiminutivo(String diminutivo) {
        Titulacion titulacion = titulacionRepository.findByDiminutivo(diminutivo)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Titulación no encontrada con diminutivo: " + diminutivo
                        )
                );
        titulacionRepository.delete(titulacion);
    }

    // =========================================================
    // MÉTODOS AUXILIARES (MAPPERS Y VALIDACIONES)
    // =========================================================
    private TitulacionResponseDto mapToResponseDto(Titulacion titulacion) {
        return new TitulacionResponseDto(
                titulacion.getId_titulacion(),
                titulacion.getCodigo(),
                titulacion.getDiminutivo(),
                titulacion.getHoras_totales()
        );
    }

    private void validarUnicidadEnActualizacion(Titulacion existente, TitulacionRequestDto datos) throws BadRequestException {
        if (!existente.getCodigo().equals(datos.codigo()) && titulacionRepository.existsByCodigo(datos.codigo())) {
            throw new BadRequestException("Ya existe otra titulación registrada con el código: " + datos.codigo());
        }
        if (!existente.getDiminutivo().equals(datos.diminutivo()) && titulacionRepository.existsByDiminutivo(datos.diminutivo())) {
            throw new BadRequestException("Ya existe otra titulación registrada con el diminutivo: " + datos.diminutivo());
        }
    }
}
