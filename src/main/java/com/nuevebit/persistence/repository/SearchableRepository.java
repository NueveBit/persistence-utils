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
    
    List<T> search(S searchCriteria, Pageable pageable);

    long count(S searchCriteria);
}
