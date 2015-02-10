/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pasteur.ci.bean;

/**
 *
 * @author HP USER
 */
public class Region {
    private int idregion;
    private String designation;
    private boolean visible;

    /**
     * @return the idregion
     */
    public int getIdregion() {
        return idregion;
    }

    /**
     * @param idregion the idregion to set
     */
    public void setIdregion(int idregion) {
        this.idregion = idregion;
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
