/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nuevebit.persistence.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author emerino
 */
public abstract class AbstractJPARepository<T> {
    
    @PersistenceContext
    private EntityManager entityManager;

    private Class<T> entityClass;

    public AbstractJPARepository(Class<T> entityClass) {
        this.entityClass = entityClass;
    }
    
    protected EntityManager getEntityManager() {
        return entityManager;
    }

    protected Class<T> getEntityClass() {
        return entityClass;
    }

}
