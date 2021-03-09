package com.dairon.crud_estudiante.controller;

import java.util.List;

import com.dairon.crud_estudiante.domain.Estudiante;
import com.dairon.crud_estudiante.service.EstudianteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/estudiantes")
public class EstudianteController {
    
    @Autowired
    private EstudianteService service;

    @PostMapping("")
    public Estudiante create(@RequestBody Estudiante estudiante){
        return service.createEstud(estudiante);
    }

    @GetMapping("")
    public List<Estudiante> list(){
        return service.listEstud();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Estudiante> get(@PathVariable("id") Long id){
        return service.getEstud(id).map(estudiante -> ResponseEntity.ok(estudiante)).orElse(ResponseEntity.noContent().build());
    }

    @PutMapping("")
    public Estudiante update(@RequestBody Estudiante estudiante){
        return service.updateEstud(estudiante);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id){
        service.deleteEstud(id);
    }

    /*@GetMapping("/listByEsp")
    public List<Estudiante> listEsp(String espe){
        return service.listEspecialidad(espe);
    }*/
}
