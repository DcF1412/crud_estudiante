package com.dairon.crud_estudiante.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.dairon.crud_estudiante.domain.Estudiante;

import org.springframework.stereotype.Repository;

@Repository
public class EstudianteDao {

    private EntityManager em;


    public EstudianteDao(EntityManager em) {
        this.em = em;
    }

    public List<Estudiante> findAllByEdad(int edad) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Estudiante> cq = cb.createQuery(Estudiante.class);
        Root<Estudiante> root = cq.from(Estudiante.class);
        Predicate p = cb.equal(root.get("edad"), edad);
        Order o = cb.asc(root.get("nombre"));
        cq.where(p).orderBy(o);

        return em.createQuery(cq).getResultList();
    }
}