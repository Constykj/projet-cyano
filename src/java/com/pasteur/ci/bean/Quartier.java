/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pasteur.ci.bean;

/**
 *
 * @author Abouchou
 */
public class Quartier {
    private int idquartier;
    private String designation;
    private boolean visible;

    /**
     * @return the idquartier
     */
    public int getIdquartier() {
        return idquartier;
    }

    /**
     * @param idquartier the quartier to set
     */
    public void setIdquartier(int quartier) {
        this.idquartier = quartier;
    }

    /**
     * @return the designation
     */
    public String getDesignation() {
        return designation;
    }

    /**
     * @param designation the designation to set
     */
    public void setDesignation(String designation) {
        this.designation = designation;
    }

    /**
     * @return the visible
     */
    public boolean isVisible() {
        return visible;
    }

    /**
     * @param visible the visible to set
     */
    public void setVisible(boolean visible) {
        this.visible = visible;
    }
}

