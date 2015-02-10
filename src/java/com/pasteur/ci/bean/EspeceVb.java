/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pasteur.ci.bean;

/**
 *
 * @author abouchou
 */
public class EspeceVb {

    public int getIdespece_vb() {
        return idespece_vb;
    }

    public void setIdespece_vb(int idespece_vb) {
        this.idespece_vb = idespece_vb;
    }
    private int idespece_vb;
    private String design_espece;

    public String getDesign_espece() {
        return design_espece;
    }

    public void setDesign_espece(String design_espece) {
        this.design_espece = design_espece;
    }
    private boolean visible;

   

   

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }
}
