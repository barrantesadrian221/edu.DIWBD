package edu.altair.bdDIW.repositories;

import edu.altair.bdDIW.entities.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Long> {
    boolean existsByDiminutivo(String diminutivo);
    List<Curso> findByDiminutivo(String diminutivo);
    void deleteByDiminutivo(String diminutivo);
    int countByDiminutivo(String diminutivo);
}
