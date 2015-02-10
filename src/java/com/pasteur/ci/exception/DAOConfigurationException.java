/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pasteur.ci.exception;

/**
 *
 * @author HP USER
 */
public class DAOConfigurationException extends RuntimeException{
    
    public DAOConfigurationException (String message){
        super(message);
    }
    
    public DAOConfigurationException (String message, Throwable cause){
        super(message, cause);
    }
    
    public DAOConfigurationException (Throwable cause){
        super(cause);
    }
}
