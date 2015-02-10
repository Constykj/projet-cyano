/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pasteur.ci.dao;

import com.pasteur.ci.exception.DAOException;
import java.util.ArrayList;

/**
 *
 * @author HP USER
 */
public interface BaseDAO<T> {    
    
    public abstract T find(T obj) throws DAOException;    
    public abstract T find(int i) throws DAOException;   
    public abstract ArrayList<T> find() throws DAOException;
    public abstract T create(T obj) throws DAOException;
    public abstract T update(T obj) throws DAOException;
    public abstract void delete(T obj) throws DAOException;
    
}
