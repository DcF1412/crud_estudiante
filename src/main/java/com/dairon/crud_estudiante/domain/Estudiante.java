package com.dairon.crud_estudiante.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "estudiante")
public class Estudiante extends Persona {

    private int level;

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

}
