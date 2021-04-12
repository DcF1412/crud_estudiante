package com.dairon.crud_estudiante.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "profesor")
public class Profesor extends Persona {

    private String especialidad;

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }
}
