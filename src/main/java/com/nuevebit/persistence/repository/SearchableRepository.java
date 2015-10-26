/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nuevebit.persistence.repository;

import java.util.List;
import org.springframework.data.domain.Pageable;

/**
 * Permite realizar búsquedas en un Repositorio.
 * TODO: Verificar si puede extender de CrudRepository.
 * 
 * @author emerino
 * @param <T> Entidad
 * @param <S> SearchCriteria 
 */
public interface SearchableRepository<T, S> {
    
    /**
     * Devuelve sólo un resultado que coincida exactamente con los criterios de
     * búsqueda especificados.
     * @param searchCriteria
     * @return 
     */
    T searchOne(S searchCriteria);
    
    /**
     * Devuelve todos los resultados que coincidan con los criterios de búsqueda
     * especificados.
     * @param searchCriteria
     * @return 
     */
    List<T> search(S searchCriteria);
    
    /**
     * Devuelve los resultados paginados de los resultados que coincidan con
     * los criterios de búsqueda definidos.
     * @param searchCriteria
     * @param pageable
     * @return 
     */
    List<T> search(S searchCriteria, Pageable pageable);

    /**
     * Cuenta los resultados que coincidan con los criterios de búsqueda.
     * @param searchCriteria
     * @return 
     */
    long count(S searchCriteria);
}
