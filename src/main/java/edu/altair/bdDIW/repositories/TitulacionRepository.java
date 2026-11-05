package edu.altair.bdDIW.repositories;

import edu.altair.bdDIW.entities.Titulacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TitulacionRepository extends JpaRepository<Titulacion, Long> {
    boolean existsByCodigo (String Codigo);
    List<Titulacion> findByCodigo(String Codigo);
    void deleteByCodigo(String codigo);
    int countByCodigo(String codigo);


    boolean existsByDiminutivo(String diminutivo);

    List<Titulacion> findByDiminutivo(String diminutivo);
    void deleteByDiminutivo(String diminutivo);
    int countByDiminutivo(String diminutivo);
}
