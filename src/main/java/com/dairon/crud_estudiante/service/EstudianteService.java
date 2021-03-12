package com.dairon.crud_estudiante.service;

import java.util.List;
import java.util.Optional;

import com.dairon.crud_estudiante.domain.Estudiante;
import com.dairon.crud_estudiante.repository.EstudianteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EstudianteService {

    @Autowired
    private EstudianteRepository repo;

    public Estudiante createEstud(Estudiante estudiante){
        return repo.save(estudiante);
    }

    public List<Estudiante> listEstud(){
        return repo.findAll();
    }

    public Optional<Estudiante> getEstud(Long id){
        return repo.findById(id);
    }

    public Estudiante updateEstud(Estudiante estudiante){
        return repo.save(estudiante);
    }

    public void deleteEstud(Long id){
        repo.deleteById(id);
    }

    //ver con el titi esta
    /*public List<Estudiante> listEspecialidad(String especialidad){
       
    }*/
}
