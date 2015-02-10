/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pasteur.ci.bean;

/**
 *
 * @author Abouchou
 */
public class PointPrelevement {

    private int idpoint_prelevement;

    public int getIdstat() {
        return idstat;
    }

    public void setIdstat(int idstat) {
        this.idstat = idstat;
    }
    private int idstat;
    private double profondeur;
    private boolean visible;
    private String designation;
     private int nombre;

    public int getNombre() {
        return nombre;
    }

    public void setNombre(int nombre) {
        this.nombre = nombre;
    }


    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public int getIdpoint_prelevement() {
        return idpoint_prelevement;
    }

    public void setIdpoint_prelevement(int idpoint_prelevement) {
        this.idpoint_prelevement = idpoint_prelevement;
    }

    public double getProfondeur() {
        return profondeur;
    }

    public void setProfondeur(double profondeur) {
        this.profondeur = profondeur;
    }

     

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }
}
