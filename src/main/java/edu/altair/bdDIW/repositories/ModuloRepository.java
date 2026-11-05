package edu.altair.bdDIW.repositories;

import edu.altair.bdDIW.entities.Modulo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ModuloRepository extends JpaRepository<Modulo, Long> {
    boolean existsByCodigo(String codigo);
    List<Modulo> findByCodigo(String codigo);
    void deleteByCodigo(String codigo);
    int countByCodigo(String codigo);
}
