package edu.altair.bdDIW.entities;
import jakarta.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Departamento",
schema="BDDIW",
    uniqueConstraints =  {
        @UniqueConstraint(name = "codigo_departamento",columnNames = "codigo")
        }
)

public class Departamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_departamento")
    private Long id_departamento;
}
