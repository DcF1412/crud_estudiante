package com.dairon.crud_estudiante.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "asignatura")
public class Asignatura extends AbstractEntity {

    private String asignatura;

    public String getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(String asignatura) {
        this.asignatura = asignatura;
    }
}
