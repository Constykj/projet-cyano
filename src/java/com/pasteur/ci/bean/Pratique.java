/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pasteur.ci.bean;

/**
 *
 * @author Abouchou
 */
public class Pratique {

    private int idpratique;
    private String pratique;
    private boolean visible;

    public int getIdpratique() {
        return idpratique;
    }

    public void setIdpratique(int idpratique) {
        this.idpratique = idpratique;
    }

    public String getPratique() {
        return pratique;
    }

    public void setPratique(String pratique) {
        this.pratique = pratique;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }
}
