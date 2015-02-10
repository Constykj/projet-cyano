/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pasteur.ci.bean;

/**
 *
 * @author Abouchou
 */
public class VibrionacesS {

    private int idvibrio;
    private String idespece_vb;
    private String idserotype_vb;

    public String getIdespece_vb() {
        return idespece_vb;
    }

    public void setIdespece_vb(String idespece_vb) {
        this.idespece_vb = idespece_vb;
    }

    public String getIdserotype_vb() {
        return idserotype_vb;
    }

    public void setIdserotype_vb(String idserotype_vb) {
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
