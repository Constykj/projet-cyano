/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pasteur.ci.bean;

/**
 *
 * @author Abouchou
 */
public class Vibrionaces {

    private int idvibrio;
    private int idespece_vb;
    private int idserotype_vb;

    public int getIdespece_vb() {
        return idespece_vb;
    }

    public void setIdespece_vb(int idespece_vb) {
        this.idespece_vb = idespece_vb;
    }

    public int getIdserotype_vb() {
        return idserotype_vb;
    }

    public void setIdserotype_vb(int idserotype_vb) {
        this.idserotype_vb = idserotype_vb;
    }
    private boolean visible;

    public int getIdvibrio() {
        return idvibrio;
    }

    public void setIdvibrio(int idvibrio) {
        this.idvibrio = idvibrio;
    }

     
    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }
}
