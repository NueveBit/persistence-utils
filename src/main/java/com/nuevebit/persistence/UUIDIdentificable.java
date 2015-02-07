/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nuevebit.persistence;

import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;

/**
 * Clase que ayuda a la implementación de entidades con UUIDs como ids.
 *
 * @author emerino
 */
@MappedSuperclass
public class UUIDIdentificable implements Identificable<UUID> {

    @Id
    @Column(length = 36, nullable = false, unique = true)
    private String id;

    @Version
    private Long version;

    public UUIDIdentificable() {
        this.id = UUID.randomUUID().toString();
    }

    @Override
    public UUID getId() {
        return UUID.fromString(id);
    }

    protected final void setId(String id) {
        setId(UUID.fromString(id));
    }

    protected final void setId(UUID id) {
        if (id == null) {
            throw new IllegalArgumentException("UUID no puede ser nulo");
        }

        this.id = id.toString();
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + (this.id != null ? this.id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final UUIDIdentificable other = (UUIDIdentificable) obj;
        return !((this.id == null) ? (other.id != null) : !this.id.equals(other.id));
    }
    private static final long serialVersionUID = 1L;

}
