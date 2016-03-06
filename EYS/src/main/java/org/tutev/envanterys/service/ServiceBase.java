/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.tutev.envanterys.service;

import java.io.Serializable;
import java.util.List;

import org.tutev.envanterys.TDbException;

/**
 *
 * @author Tütev
 */
public interface ServiceBase<T> extends Serializable {
    
   public T save(T entity) throws TDbException;
   
   public List<T> getAll();
      
   public Boolean update(T entity);
      
   public Boolean delete(T entity);
   
   public T getById(Long id);
}
