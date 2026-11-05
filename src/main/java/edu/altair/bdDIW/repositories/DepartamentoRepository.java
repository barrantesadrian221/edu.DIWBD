package edu.altair.bdDIW.repositories;

import edu.altair.bdDIW.entities.Departamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartamentoRepository extends JpaRepository<Departamento, Long> {
    boolean existsByCodigo(int codigo);
    List<Departamento> findByCodigo(int codigo);
    void deleteByCodigo(int codigo);
    int countByCodigo(int codigo);
}
