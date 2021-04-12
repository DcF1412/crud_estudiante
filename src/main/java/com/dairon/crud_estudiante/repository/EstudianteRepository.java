package com.dairon.crud_estudiante.repository;

import java.util.List;

import com.dairon.crud_estudiante.domain.Estudiante;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EstudianteRepository extends JpaRepository<Estudiante, Long> {

    // operador -> = igual, <> distinto, > mayor, < menor, <=, >=
    // select [<campo1, campo2, campoN> or * <para todas las columnas>] from [tabla]
    // [where campoX {operador} valor]

    // query en dql
    @Query("select e from Estudiante e where e.level = :level") // select * from estudiante where level='Chofer'
    List<Estudiante> loquenosdalagana(String level);

    // lazy loading
    List<Estudiante> findAllByEdadOrderByNombreAsc(int edad);
}
