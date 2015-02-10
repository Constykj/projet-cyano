/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pasteur.ci.bean;

/**
 *
 * @author abouchou
 */
public class SerotypeVb {

    public int getIdserotype_vb() {
        return idserotype_vb;
    }

    public void setIdserotype_vb(int idserotype_vb) {
        this.idserotype_vb = idserotype_vb;
    }

    public String getDesign_serotype() {
        return design_serotype;
    }

    public void setDesign_serotype(String design_serotype) {
        this.design_serotype = design_serotype;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }
    private int idserotype_vb;
    private String design_serotype;
    private boolean visible;
}
