package edu.altair.bdDIW.repositories;

import edu.altair.bdDIW.entities.Modulo_Estado_Alumno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Modulo_Estado_AlumnoRepository extends JpaRepository<Modulo_Estado_Alumno, Long> {
}
