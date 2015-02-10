/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pasteur.ci.exception;

/**
 *
 * @author HP USER
 */
public class DAOException extends RuntimeException{
    
    public DAOException (String message){
        super(message);
    }
    
    public DAOException (String message, Throwable cause){
        super(message, cause);
    }
    
    public DAOException (Throwable cause){
        super(cause);
    }
}
