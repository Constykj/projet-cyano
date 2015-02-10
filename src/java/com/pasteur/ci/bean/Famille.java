/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pasteur.ci.bean;

/**
 *
 * @author Abouchou
 */
public class Famille {
    private int idfamille;
    private String design_famille;
    private boolean visible;

    public int getIdfamille() {
        return idfamille;
    }

    public void setIdfamille(int idfamille) {
        this.idfamille = idfamille;
    }

    public String getDesign_famille() {
        return design_famille;
    }

    public void setDesign_famille(String design_famille) {
        this.design_famille = design_famille;
    }
    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }
    
}
