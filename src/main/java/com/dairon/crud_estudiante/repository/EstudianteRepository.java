package com.dairon.crud_estudiante.repository;

import com.dairon.crud_estudiante.domain.Estudiante;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstudianteRepository extends JpaRepository<Estudiante, Long>{
    
}
