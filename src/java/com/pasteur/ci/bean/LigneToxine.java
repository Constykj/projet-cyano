/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pasteur.ci.bean;

/**
 *
 * @author Abouchou
 */
public class LigneToxine  {

    private int idespece_cyano;
    private int idtoxine;
    private  int idligne_toxine;
    private double concentration;
    
     public int getIdespece_cyano() {
        return idespece_cyano;
    }

    public void setIdespece_cyano(int idespece_cyano) {
        this.idespece_cyano = idespece_cyano;
    }

    public int getIdtoxine() {
        return idtoxine;
    }

    public void setIdtoxine(int idtoxine) {
        this.idtoxine= idtoxine;
    }

    public int getIdligne_toxine() {
        return idligne_toxine;
    }

    public void setIdligne_toxine(int idligne_toxine) {
        this.idligne_toxine = idligne_toxine;
    }

    /**
     * @return the concentration
     */
    public double getConcentration() {
        return concentration;
    }

    /**
     * @param concentration the concentration to set
     */
    public void setConcentration(double concentration) {
        this.concentration = concentration;
    }
}



