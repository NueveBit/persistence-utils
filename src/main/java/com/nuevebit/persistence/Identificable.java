/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nuevebit.persistence;

import java.io.Serializable;

/**
 *
 * @author emerino
 */
public interface Identificable<T extends Serializable> extends Serializable {
    
    T getId();
}
