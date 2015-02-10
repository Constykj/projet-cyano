/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pasteur.ci.bean;

/**
 *
 * @author Abouchou
 */
public class Ptpr {
    private String idstat;
    private double profondeur;
    private boolean visible;
    private int idpoint_prelevement;
    private String designation;

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getIdstat() {
        return idstat;
    }

    public void setIdstat(String idstat) {
        this.idstat = idstat;
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

    public int getIdpoint_prelevement() {
        return idpoint_prelevement;
    }

    public void setIdpoint_prelevement(int idpoint_prelevement) {
        this.idpoint_prelevement = idpoint_prelevement;
    }
}
