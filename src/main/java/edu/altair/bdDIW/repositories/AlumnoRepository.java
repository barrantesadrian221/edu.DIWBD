package edu.altair.bdDIW.repositories;

import edu.altair.bdDIW.entities.Alumno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AlumnoRepository extends JpaRepository<Alumno, Long> {
    boolean existsByDni(String dni);
    Optional<Alumno> findByDni(String dni);

    void deleteByDni(String dni);
    int countByDni(String dni);
}
