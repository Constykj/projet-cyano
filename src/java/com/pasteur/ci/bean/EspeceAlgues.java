/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pasteur.ci.bean;

/**
 *
 * @author abouchou
 */
public class EspeceAlgues {
     private int idespece_algue;
    private String design_espece_algue;
    private int idgenre_algue;
     private String genre_algue;
    private boolean visible;

    public int getIdespece_algue() {
        return idespece_algue;
    }

    public void setIdespece_algue(int idespece_algue) {
        this.idespece_algue = idespece_algue;
    }

    public String getDesign_espece_algue() {
        return design_espece_algue;
    }

    public void setDesign_espece_algue(String design_espece_algue) {
        this.design_espece_algue = design_espece_algue;
    }

    public int getIdgenre_algue() {
        return idgenre_algue;
    }

    public void setIdgenre_algue(int idgenre_algue) {
        this.idgenre_algue = idgenre_algue;
    }

    public String getGenre_algue() {
        return genre_algue;
    }

    public void setGenre_algue(String genre_algue) {
        this.genre_algue = genre_algue;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }
}
