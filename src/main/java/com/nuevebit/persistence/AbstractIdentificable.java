/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nuevebit.persistence;

import java.io.Serializable;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;

/**
 * Clase base para entidades identificables.
 *
 * @author emerino
 */
@MappedSuperclass
public abstract class AbstractIdentificable<T extends Serializable>
        implements Identificable<T> {
    
    private static final long serialVersionUID = 4005618837053853500L;

    @Version
    private long version;

    private T id;

    public T getId() {
        return id;
    }

    public void setId(T id) {
        this.id = id;
    }
}
