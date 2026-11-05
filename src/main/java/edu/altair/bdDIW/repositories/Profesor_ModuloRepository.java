package edu.altair.bdDIW.repositories;

import edu.altair.bdDIW.entities.Profesor_Modulo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Profesor_ModuloRepository extends JpaRepository<Profesor_Modulo, Long> {
}
