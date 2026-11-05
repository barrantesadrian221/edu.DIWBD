package edu.altair.bdDIW.repositories;

import edu.altair.bdDIW.entities.Familia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadoRepository extends JpaRepository<Familia, Long> {
}
