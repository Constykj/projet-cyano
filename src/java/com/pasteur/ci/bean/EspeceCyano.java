/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pasteur.ci.bean;

/**
 *
 * @author Abouchou
 */
public class EspeceCyano {

    private int idespece_cyano;
    private int idgenre_cyano;
    private String design_espece_cyano;
    private boolean visible;

    public int getIdgenre_cyano() {
        return idgenre_cyano;
    }

    public void setIdgenre_cyano(int idgenre_cyano) {
        this.idgenre_cyano = idgenre_cyano;
    }

    public int getIdespece_cyano() {
        return idespece_cyano;
    }

    public void setIdespece_cyano(int idespece_cyano) {
        this.idespece_cyano = idespece_cyano;
    }

    public String getDesign_espece_cyano() {
        return design_espece_cyano;
    }

    public void setDesign_espece_cyano(String esign_espece_cyano) {
        this.design_espece_cyano = esign_espece_cyano;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

}
