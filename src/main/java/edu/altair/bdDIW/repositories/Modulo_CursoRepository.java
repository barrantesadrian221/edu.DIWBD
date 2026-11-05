package edu.altair.bdDIW.repositories;

import edu.altair.bdDIW.entities.Modulo_Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Modulo_CursoRepository extends JpaRepository<Modulo_Curso, Long> {
}
