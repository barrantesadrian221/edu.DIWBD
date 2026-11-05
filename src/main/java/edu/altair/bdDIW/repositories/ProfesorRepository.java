package edu.altair.bdDIW.repositories;

import edu.altair.bdDIW.entities.Profesor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProfesorRepository extends JpaRepository<Profesor, Long> {
    boolean existsByDni(String dni);
    List<Profesor> findByDni(String dni);
    void deleteByDni(String dni);
    int countByDni(String dni);
}
