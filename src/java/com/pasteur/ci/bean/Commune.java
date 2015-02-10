/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pasteur.ci.bean;

/**
 *
 * @author Abouchou
 */
public class Commune {
    /*
     * To change this template, choose Tools | Templates
     * and open the template in the editor.
     */

    private int idcommune;
    private String designation;
    private boolean visible;

    /**
     * @return the idcommune
     */
    public int getIdcommune() {
        return idcommune;
    }

    /**
     * @param idcommune the commune to set
     */
    public void setIdcommune(int commune) {
        this.idcommune = commune;
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
