package com.dairon.crud_estudiante.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import com.dairon.crud_estudiante.domain.Estudiante;
import com.dairon.crud_estudiante.repository.EstudianteDao;
import com.dairon.crud_estudiante.repository.EstudianteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EstudianteService {

    @Autowired
    private EstudianteRepository repo;
    @Autowired
    private EstudianteDao emRepo;

    public Estudiante createEstud(Estudiante estudiante) {
        return repo.save(estudiante);
    }

    public List<Estudiante> listEstud() {
        return repo.findAll();
    }

    public Optional<Estudiante> getEstud(Long id) {
        return repo.findById(id);
    }

    public Estudiante updateEstud(Estudiante estudiante) {
        return repo.save(estudiante);
    }

    public void deleteEstud(Long id) {
        repo.deleteById(id);
    }

    public List<Estudiante> listEspecialidad(String especialidad) {
        return repo.loquenosdalagana(especialidad);
    }

    public List<Estudiante> listEdad(int edad) {
        return emRepo.findAllByEdad(edad);
        //return repo.findAllByEdadOrderByNombreAsc(edad);
    }

    //peor de los casos
    /* public List<Estudiante> listEdadFiltered(int edad) {
        List<Estudiante> estudiantes = repo.findAll();
        List<Estudiante> result = new ArrayList<>();
        for (Estudiante estudiante : estudiantes) {
            if(estudiante.getEdad() == edad) {
                result.add(estudiante);
            }
        }
        return result;
    } */

    //caso promedio
    /* public List<Estudiante> listEdadFiltered(int edad) {
        List<Estudiante> estudiantes = new ArrayList<>(repo.findAll());
        Iterator<Estudiante> iterator = estudiantes.iterator();
        while(iterator.hasNext()) {
            if(iterator.next().getEdad() != edad) {
                iterator.remove();
            }
        }
        return estudiantes;
    } */

    //mejor de los casos
    public List<Estudiante> listEdadFiltered(int edad) {
        return repo.findAll()
            .stream()
            .filter(e -> e.getEdad() == edad)
            .collect(Collectors.toList());
    }
}
